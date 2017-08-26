package net.proselyte.hibernate;

import net.proselyte.hibernate.annotations.User;
import net.proselyte.hibernate.servise.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
//@RequestMapping("/")
public class HelloController {
    @Autowired
    @Qualifier("devHibernateService")
    private DeveloperService developerService;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String printWelcome0(ModelMap model) {
        model.addAttribute("message", "Hello, Andrey!");
        model.addAttribute("message2", "I love you!");
        return "index";
    }


    @RequestMapping(value = "/viewusers", method = RequestMethod.GET)
    public String printHibernate(ModelMap model) {
        List<User> listResults = developerService.listDevelopersReturn();
        model.addAttribute("listResults", listResults);
        return "viewusers-2";
    }

    @RequestMapping(value = "/adduserform", method = RequestMethod.GET)
    public String printHibernate2(ModelMap model) {
        // model.addAttribute("listResults", 1);
        // ModelAndView mav = new ModelAndView("listResults") ;
        //   mav.addObject("listResults", listResults);
        return "test-2";
    }

    @RequestMapping(value = "/adduserform", method = RequestMethod.POST)

    public String printHibernate9(@PathVariable User user) {
        developerService.addDeveloper(user);


        return "adduser-success";
    }

    @RequestMapping(value = "/successRegistration")
    public String printHibernate7(ModelMap model) {
      return "adduser-success";
    }

    @RequestMapping(value = "/adduser-error")
    public String printHibernate8(ModelMap model) {
        return "adduser-error";
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