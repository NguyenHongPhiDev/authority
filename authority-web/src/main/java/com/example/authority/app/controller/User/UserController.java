package com.example.authority.app.controller.User;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;

@Controller
@RequiredArgsConstructor
public class UserController {
    @GetMapping("/user")
    public String viewProfile(Model model){
        return "user/index";
    }
}
