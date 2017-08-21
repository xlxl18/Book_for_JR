package net.proselyte.hibernate;


import net.proselyte.hibernate.annotations.Developer;
import net.proselyte.hibernate.servise.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
public class HibernateController {

    @Autowired
    @Qualifier("devHibernateService")
    private DeveloperService developerService;

    @RequestMapping(value = "/allDev", method = RequestMethod.GET)
    public String printHibernate(ModelMap model) {

        List<Developer> listAllDev = developerService.listDevelopersReturn();

        model.addAttribute("listAllDev",listAllDev);

        return "hello2";
    }

    @RequestMapping(value = "/22", method = RequestMethod.GET)
    public String printHibernate2(ModelMap model) {
        String qqq;
        List<Developer> listAllDev = developerService.listDevelopersReturn();

        System.out.println(listAllDev.toString());
        if (listAllDev.size() == 0) {qqq = "Is Empty result";}
        qqq = listAllDev.get(2).toString();


        model.addAttribute("message", "Hello world! - 3");
        model.addAttribute("message2", qqq);
       //model.addAttribute("message", "Hello world! - 3");

        return "hello3";
    }

}
