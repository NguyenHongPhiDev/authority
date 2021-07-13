package com.example.authority.app.controller;

import com.example.authority.domain.model.User;
import com.example.authority.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class HelloController {

    private final UserService userService ;
    @RequestMapping(value = "/login", method = {RequestMethod.GET,RequestMethod.POST})
    public String home() {
        return "login/login";
    }
    @GetMapping("/")
    public String home1(Model model,Principal principal) {
        String username = principal.getName();
        model.addAttribute("username",username);
        model.addAttribute("role", SecurityContextHolder.getContext().getAuthentication().getAuthorities());

        return "welcome/home";
    }

    @GetMapping("/user")
    public String home2() {
        return "welcome/user";
    }
    @GetMapping("/admin")
    public String home3(Model model,Principal  principal) {
        String username = principal.getName();
        model.addAttribute("username",username);
        model.addAttribute("role", SecurityContextHolder.getContext().getAuthentication().getAuthorities());
        List<User> userList = userService.userList();
        model.addAttribute("userList",userList);
        Object a = model.getAttribute("description");
        model.addAttribute("abc",a);
        return "welcome/admin";
    }
    @GetMapping("/home")
    public String home4() {
        return "welcome/index";
    }
}
