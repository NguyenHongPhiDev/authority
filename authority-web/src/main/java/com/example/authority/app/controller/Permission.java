package com.example.authority.app.controller;

import com.example.authority.domain.model.Action;
import com.example.authority.domain.model.User;
import com.example.authority.domain.service.PermissionService;
import com.example.authority.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class Permission {
    private final UserService userService;
    private final PermissionService permissionService ;
    @RequestMapping(value = "/permission", method = {RequestMethod.POST,RequestMethod.GET},params = "user_id")
    public String updatePermission(Model model, @RequestParam(value = "user_id") Integer id){
        String [] favLanguages;
        User user = userService.findById(id);
        List<Action> actionList = permissionService.getAllPermission();
        model.addAttribute("actions",actionList);
        model.addAttribute("User",user);
        return "welcome/permission";
    }
}
