package com.example.authority.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    @GetMapping("/update")
    public String updateUser(){
        return "user/update";
    }
    @GetMapping("/delete")
    public String delete(){
        return "user/delete";
    }
    @GetMapping("/create")
    public String create(){
        return "user/create";
    }
}
