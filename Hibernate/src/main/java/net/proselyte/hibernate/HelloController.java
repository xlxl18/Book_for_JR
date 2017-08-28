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
@SessionAttributes("user")
public class HelloController {
    @Autowired
    @Qualifier("devHibernateService")
    private UserService developerService;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String printWelcome0(ModelMap model) {
        model.addAttribute("message", "Hello, javaRash!");
        model.addAttribute("message2", "Make your choice, please.");
        return "index";
    }


    @RequestMapping(value = "/viewusers", method = RequestMethod.GET)
    public String printHibernate(ModelMap model) {
        List<User> listResults = developerService.listDevelopersReturn();
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
         developerService.addDeveloper(user.getName(), user.getAge(), user.getIsAdmin(), user.getDate());
        model.addAttribute("message", "User successfully saved!");
        model.addAttribute("message2", "Make your choice, please.");
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/editUser", method = RequestMethod.GET)
    public ModelAndView editUser(@RequestParam int id, @ModelAttribute User user) {
        ModelAndView mv = new ModelAndView();
        user = developerService.getUser(id);
        mv.addObject("message", "Edit User");
        mv.addObject("message2", "editUser");
        mv.setViewName("adduser");//страничка jsp которую я вызываю
        mv.addObject( "userDate", user);
        return mv;
    }

    @RequestMapping(value = "/editUser", method = RequestMethod.POST)
    public ModelAndView testing4 (@ModelAttribute ("user") User user, ModelMap model) {
        developerService.updateDeveloper(user);
        model.addAttribute("message", "User successfully saved!");
        model.addAttribute("message2", "Make your choice, please.");
        return new ModelAndView("index");
    }





    // *********************************************************************************


    @RequestMapping(value = "/successRegistration")
    public String printHibernate7(ModelMap model) {
      return "adduser-success";
    }

    @RequestMapping(value = "/adduser-error")
    public String printHibernate8(ModelMap model) {
        return "adduser-error";
    }

    @RequestMapping("deleteUser")
    public String deleteUser(@RequestParam int id, ModelMap model)
    {

        developerService.removeDeveloper(id);
        List<User> listResults = developerService.listDevelopersReturn();
        model.addAttribute("listResults", listResults);
        return "viewusers";
    }

    @RequestMapping("searchUser")
    public ModelAndView searchUser(@RequestParam("searchName") String searchName){

        List<User> userList = developerService.getAllUsers(searchName);
        return new ModelAndView("userList", "userList", userList);
    }

    @RequestMapping(value = "/getData", method = RequestMethod.GET)
    public ResponseEntity<String> getData() {
        return new ResponseEntity<String>("TEST!", HttpStatus.OK);
    }
/*
	@RequestMapping(value="/1", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		model.addAttribute("message", "Hello world! - index.jsp");
		return "index";
	}

    @RequestMapping(value="/2", method = RequestMethod.GET)
    public String printWelcome2(ModelMap model) {
        model.addAttribute("message", "Hello world! - 2");
        return "hello2";
    }


    @RequestMapping(value="/3", method = RequestMethod.GET)
    public String printWelcome3(ModelMap model) {

        model.addAttribute("message", "Hello world! - 3");
        model.addAttribute("message", "Hello world! - 3");

      //  DeveloperRunner.listDevelopersReturn();
        return "hello3";
    }

    @RequestMapping(value="/4", method = RequestMethod.GET)
    public String printWelcome4(ModelMap model) {

        return "index1";
    }
*/


}