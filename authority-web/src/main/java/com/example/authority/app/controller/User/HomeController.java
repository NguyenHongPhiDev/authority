package com.example.authority.app.controller.User;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class HomeController {
    @GetMapping("/")
    public String home1(Model model, Principal principal) {
        String username = "chưa đăng nhập";
        model.addAttribute("username",username);
        return "layout/index";
    }
}
