package com.example.authority.app.controller;

import com.example.authority.domain.Dto.CheckDto;
import com.example.authority.domain.Dto.request.PermissionRequest;
import com.example.authority.domain.model.Action;
import com.example.authority.domain.model.User;
import com.example.authority.domain.service.PermissionService;
import com.example.authority.domain.service.RoleService;
import com.example.authority.domain.service.UserRoleService;
import com.example.authority.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
@RequiredArgsConstructor
public class Permission {
    private final UserService userService;
    private final PermissionService permissionService ;
    private final UserRoleService userRoleService;
    @RequestMapping(value = "/permission", method = {RequestMethod.POST,RequestMethod.GET},params = "user_id")
    public String updatePermission(Model model, @RequestParam(value = "user_id") Integer id){
        User user = userService.findById(id);
        List<Action> actionList = permissionService.getAllPermission();
        model.addAttribute("actions",actionList);
        model.addAttribute("User",user);
        return "welcome/permission";
    }
    @RequestMapping(value = "/permission/update", method = {RequestMethod.POST,RequestMethod.GET})
    public String update(Model model, HttpServletRequest request){
        Map<String, String[]> map = request.getParameterMap();
        String[] checkList;
        checkList  = map.get("listChecked[]");
        String[] uncheckList;
        uncheckList = map.get("listUncheck[]");
        String[] userIds = map.get("user_id");
        String a = userIds[0];
        Integer a1 = Integer.valueOf(a);
        Integer role_id = userRoleService.findRoleId(a1);
        if(checkList != null){
            for (int i=0; i < checkList.length; i++) {
                permissionService.Insert(role_id, Integer.valueOf(checkList[i]));
            }
        }
        if(uncheckList != null){
            for (int i=0; i < uncheckList.length; i++) {
                permissionService.Delete(role_id, Integer.valueOf(uncheckList[i]));
            }
        }
        return "welcome/permission" ;
    }
}
