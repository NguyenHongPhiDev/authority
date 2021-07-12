package com.example.authority.app.welcome;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HelloController {
    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
    public String home() {
        return "login/login";
    }
    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.POST})
    public String home1() {
        return "welcome/home";
    }

    @RequestMapping(value = "/user", method = {RequestMethod.GET, RequestMethod.POST})
    public String home2() {
        return "welcome/user";
    }
    @RequestMapping(value = "/admin", method = {RequestMethod.GET, RequestMethod.POST})
    public String home3() {
        return "welcome/admin";
    }
    @RequestMapping(value = "/home", method = {RequestMethod.GET, RequestMethod.POST})
    public String home4() {
        return "welcome/index";
    }
}
