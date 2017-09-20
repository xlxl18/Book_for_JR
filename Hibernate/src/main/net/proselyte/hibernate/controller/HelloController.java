package net.proselyte.hibernate.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.sql.Timestamp;
import net.proselyte.hibernate.annotations.User;
import net.proselyte.hibernate.servise.Json.UserJsonObject;
import net.proselyte.hibernate.servise.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
//@SessionAttributes("user")
public class HelloController {
    @Autowired
    private UserService userService;




    @RequestMapping(value="/", method = RequestMethod.GET)//есть тест
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "Hello, javaRash!");
        model.addAttribute("message2", "Make your choice, please.");
        return "index";
    }

    @RequestMapping(value = "/viewusers", method = RequestMethod.GET) //есть тест
    public String viewusers() {
      return "viewusers";
    }

    @RequestMapping("/deleteUser") //есть тест
    public String deleteUser(@RequestParam int id)
    {   userService.removeUser(id);
        return "viewusers";
    }

    @RequestMapping(value = "/springPaginationDataTables.web", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody String springPaginationDataTables(HttpServletRequest request) throws IOException {

        //Fetch Page display length
        // Получить Длительность отображения страницы
        Integer pageDisplayLength = Integer.valueOf(request.getParameter("iDisplayLength"));
        //Fetch the page number from client
        // Получить номер страницы с клиента
        Integer pageNumber = 0;
        if (null != request.getParameter("iDisplayStart"))
        {pageNumber = (Integer.valueOf(request.getParameter("iDisplayStart")) / pageDisplayLength) + 1;}


        //Fetch search parameter
        // Выбор параметра поиска
        String searchParameter = request.getParameter("sSearch");


        //Create page list data
        // Создание данных списка страниц
        List<User> personsList = createPaginationDataOnSearchParameter(pageNumber, pageDisplayLength, searchParameter);

        //Here is server side pagination logic. Based on the page number you could make call
        //to the data base create new list and send back to the client. For demo I am shuffling
        //the same list to show data randomly
        // Здесь представлена логика разбиения на страницы на стороне сервера. На основании номера страницы,
        // которую вы могли бы позвонить в базу данных создаем новый список и отправляем обратно клиенту.

        //Search functionality: Returns filtered list based on search parameter
        // Функция поиска: возвращает список фильтров на основе параметра поиска

        UserJsonObject userJsonObject = new UserJsonObject();
        //Set Total display record
        // Встановити повний відображення запису до фильтрации

        userJsonObject.setiTotalDisplayRecords(userService.getCountUsers());
        //Set Total record
        // Встановити загальну кількість записів после фильтрации
        userJsonObject.setiTotalRecords(personsList.size());
        userJsonObject.setAaData(personsList);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        return gson.toJson(userJsonObject);
    }

    public List<User> createPaginationDataOnSearchParameter(Integer pageNumber, Integer pageDisplayLength, String searchParameter) {
        int start = (pageNumber - 1) * pageDisplayLength ;
        int maxRows = pageDisplayLength;
        return userService.listUsersReturnFROM(start, maxRows, searchParameter);
    }

    @RequestMapping(value = "/adduserform", method = RequestMethod.GET) //есть тест
    public ModelAndView adduserform() {
        //method 1
        ModelAndView mv = new ModelAndView();
        mv.addObject("message", "Add New User");
        mv.addObject("message2", "adduserform");
        mv.setViewName("adduser");//страничка jsp которую я вызываю
        User user = new User();
        user.setDate(new Timestamp(System.currentTimeMillis()));
        mv.addObject("user", user);

        return mv;
        //method 2
        // return new ModelAndView("test-4", "user", new User());
    }

    @RequestMapping(value = "/adduserform", method = RequestMethod.POST)//есть тест
    public ModelAndView adduserform (@ModelAttribute ("user") User user, ModelMap model) {
        userService.addUser(user.getName(), user.getAge(), user.getIsAdmin(), new Timestamp(System.currentTimeMillis()));
        model.addAttribute("message", "User successfully saved!");
        model.addAttribute("message2", "Make your choice, please.");

        return new ModelAndView("index");
    }

    @RequestMapping(value = "/editUser", method = RequestMethod.GET)
    public ModelAndView editUser(@RequestParam int id, @ModelAttribute User user) {
        ModelAndView mv = new ModelAndView();

        user = userService.getUser(id);
        mv.addObject( "userDate", user);
        mv.addObject("message", "Edit User");
        mv.addObject("message2", "editUser");

        mv.setViewName("adduser");//страничка jsp которую я вызываю
        return mv;
    }

    @RequestMapping(value = "/editUser", method = RequestMethod.POST)
    public ModelAndView editUser (@ModelAttribute ("user") User user, ModelMap model) {
        int idOldUser = user.getId();
        int idNewUser =  userService.updateUser(user);

        if (idOldUser != idNewUser) {
        model.addAttribute("message", "User "+user.getName()+ " successfully edited!");
        model.addAttribute("message2", "Make your choice, please.");
        }

        else {
        model.addAttribute("message", "User "+user.getName()+ " successfully edited!");
        model.addAttribute("message2", "Make your choice, please.");
        }
        return new ModelAndView("index");
    }
/*
    @RequestMapping("searchUser")
    public ModelAndView searchUser(@RequestParam("searchName") String searchName){
        List<User> userList = userService.getAllUsers(searchName);
        return new ModelAndView("userList", "userList", userList);
    }
*/


}