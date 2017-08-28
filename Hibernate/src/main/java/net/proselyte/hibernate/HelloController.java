package net.proselyte.hibernate;

import net.proselyte.hibernate.annotations.User;
import net.proselyte.hibernate.servise.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
//@SessionAttributes("user")
public class HelloController {
    @Autowired
    @Qualifier("devHibernateService")
    private UserService userService;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String printWelcome0(ModelMap model) {
        model.addAttribute("message", "Hello, javaRash!");
        model.addAttribute("message2", "Make your choice, please.");
        return "index";
    }

    @RequestMapping(value = "/viewusers", method = RequestMethod.GET)
    public String printHibernate(ModelMap model) {
        List<User> listResults = userService.listUsersReturn();
        model.addAttribute("listResults", listResults);
        return "viewusers";
    }

    @RequestMapping(value = "/adduserform", method = RequestMethod.GET)
    public ModelAndView testing() {
        //method 1
        ModelAndView mv = new ModelAndView();
        mv.addObject("message", "Add New User");
        mv.addObject("message2", "adduserform");
        mv.setViewName("adduser");//страничка jsp которую я вызываю
        mv.addObject("user", new User());
        return mv;
        //method 2
        // return new ModelAndView("test-4", "user", new User());
    }

    @RequestMapping(value = "/adduserform", method = RequestMethod.POST)
    public ModelAndView testing2 (@ModelAttribute ("user") User user, ModelMap model) {
        userService.addUser(user.getName(), user.getAge(), user.getIsAdmin(), user.getDate());
        model.addAttribute("message", "User successfully saved!");
        model.addAttribute("message2", "Make your choice, please.");
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/editUser", method = RequestMethod.GET)
    public ModelAndView editUser(@RequestParam int id, @ModelAttribute User user) {
        ModelAndView mv = new ModelAndView();
        user = userService.getUser(id);
        mv.addObject("message", "Edit User");
        mv.addObject("message2", "editUser");
        mv.setViewName("adduser");//страничка jsp которую я вызываю
        mv.addObject( "userDate", user);
        return mv;
    }

    @RequestMapping(value = "/editUser", method = RequestMethod.POST)
    public ModelAndView testing4 (@ModelAttribute ("user") User user, ModelMap model) {
        userService.updateUser(user);
        model.addAttribute("message", "User successfully saved!");
        model.addAttribute("message2", "Make your choice, please.");
        return new ModelAndView("index");
    }

    @RequestMapping("deleteUser")
    public String deleteUser(@RequestParam int id, ModelMap model)
    {   userService.removeUser(id);
        List<User> listResults = userService.listUsersReturn();
        model.addAttribute("listResults", listResults);
        return "viewusers";
    }

    @RequestMapping("searchUser")
    public ModelAndView searchUser(@RequestParam("searchName") String searchName){
        List<User> userList = userService.getAllUsers(searchName);
        return new ModelAndView("userList", "userList", userList);
    }

    @RequestMapping(value = "/getData", method = RequestMethod.GET)
    public ResponseEntity<String> getData() {
        return new ResponseEntity<String>("TEST!", HttpStatus.OK);
    }

}