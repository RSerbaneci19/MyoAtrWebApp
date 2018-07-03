package tango.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tango.webapp.model.User;

@Controller
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "index";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String showHomepage() {
        return "index";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String redirectHome() {
        return "index";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(Model model) {
        model.addAttribute("admin", new User());
        return "admin";
    }

}
