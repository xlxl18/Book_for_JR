package net.proselyte.hibernate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping("/")
public class HelloController {

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String printWelcome0(ModelMap model) {
        model.addAttribute("message", "Hello world! - 0");
        return "hello";
    }

	@RequestMapping(value="/1", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		model.addAttribute("message", "Hello world! - 1");
		return "hello";
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

        return "hello3";
    }

}