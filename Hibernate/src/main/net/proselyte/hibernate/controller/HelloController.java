package net.proselyte.hibernate.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.sql.Timestamp;
import net.proselyte.hibernate.annotations.Book;
import net.proselyte.hibernate.servise.Json.JsonObject;
import net.proselyte.hibernate.servise.BookService;
import org.springframework.beans.factory.annotation.Autowired;
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
    private BookService bookService;




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
    {   bookService.removeBook(id);
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
        List<Book> personsList = createPaginationDataOnSearchParameter(pageNumber, pageDisplayLength, searchParameter);

        //Here is server side pagination logic. Based on the page number you could make call
        //to the data base create new list and send back to the client. For demo I am shuffling
        //the same list to show data randomly
        // Здесь представлена логика разбиения на страницы на стороне сервера. На основании номера страницы,
        // которую вы могли бы позвонить в базу данных создаем новый список и отправляем обратно клиенту.

        //Search functionality: Returns filtered list based on search parameter
        // Функция поиска: возвращает список фильтров на основе параметра поиска

        JsonObject userJsonObject = new JsonObject();
        //Set Total display record
        // Встановити повний відображення запису до фильтрации

        userJsonObject.setiTotalDisplayRecords(bookService.getCountBooks());
        //Set Total record
        // Встановити загальну кількість записів после фильтрации
        userJsonObject.setiTotalRecords(personsList.size());
        userJsonObject.setAaData(personsList);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        return gson.toJson(userJsonObject);
    }

    public List<Book> createPaginationDataOnSearchParameter(Integer pageNumber, Integer pageDisplayLength, String searchParameter) {
        int start = (pageNumber - 1) * pageDisplayLength ;
        int maxRows = pageDisplayLength;
        return bookService.listBooksReturnFROM(start, maxRows, searchParameter);
    }

    @RequestMapping(value = "/addBookForm", method = RequestMethod.GET) //есть тест
    public ModelAndView adduserform() {
        //method 1
        ModelAndView mv = new ModelAndView();
        mv.addObject("message", "Add New User");
        mv.addObject("message2", "addBookform");
        mv.setViewName("addBook");//страничка jsp которую я вызываю
        Book book = new Book();
        mv.addObject("book", book);
        return mv;
    }
//String title, String description, String author, String isbn, int printYear, boolean readAlready
    @RequestMapping(value = "/adduserform", method = RequestMethod.POST)//есть тест
    public ModelAndView adduserform (@ModelAttribute ("user") Book book, ModelMap model) {
        bookService.addBook(book.getTitle(), book.getDescription(), book.getAuthor(), book.getIsbn(),book.getPrintYear(),  book.isReadAlready());
        model.addAttribute("message", "User successfully saved!");
        model.addAttribute("message2", "Make your choice, please.");

        return new ModelAndView("index");
    }

    @RequestMapping(value = "/editBook", method = RequestMethod.GET)
    public ModelAndView editUser(@RequestParam int id, @ModelAttribute Book book) {
        ModelAndView mv = new ModelAndView();

        book = bookService.getBook(id);
        mv.addObject( "BookDate", book);
        mv.addObject("message", "Edit Book");
        mv.addObject("message2", "editBook");

        mv.setViewName("adduser");//страничка jsp которую я вызываю
        return mv;
    }

    @RequestMapping(value = "/editUser", method = RequestMethod.POST)
    public ModelAndView editUser (@ModelAttribute ("book") Book book, ModelMap model) {
        int idOldUser = book.getId();
        int idNewUser =  bookService.updateBook(book);

        if (idOldUser != idNewUser) {
        model.addAttribute("message", "User "+book.getTitle()+ " successfully edited!");
        model.addAttribute("message2", "Make your choice, please.");
        }

        else {
        model.addAttribute("message", "User "+book.getTitle()+ " successfully edited!");
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