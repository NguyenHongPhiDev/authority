package com.example.authority.app.controller.Adminstration;

import com.example.authority.domain.model.Action;
import com.example.authority.domain.model.Food;
import com.example.authority.domain.model.User;
import com.example.authority.domain.service.FoodService;
import com.example.authority.domain.service.PermissionService;
import com.example.authority.domain.service.UserRoleService;
import com.example.authority.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class AdminController {
    private final UserService userService ;
    private final FoodService foodService;
    private final PermissionService permissionService ;
    private final UserRoleService userRoleService;

    /*=========================== Begin Admin ===========================*/
    @GetMapping("/admin")
    public String viewAdmin(){
        return "administration/index";
    }
    /*=========================== End Admin ===========================*/


    /*=========================== Begin Food ===========================*/
    @GetMapping("/admin/food")
    public String  selectFood(Model model){
        List<Food> foodList = foodService.getAllFood();
        model.addAttribute("food",foodList);
        return "administration/product/food";
    }
    @GetMapping(value = "/food",params ="addFood" )
    public String CreateFood(){
        return "administration/product/createFood";
    }

    /*=========================== End Food ===========================*/


    /*=========================== Begin Permission ===========================*/
    @RequestMapping(value = "/admin/permission", method = {RequestMethod.POST,RequestMethod.GET})
    public String viewPermission(Model model){
        List<Action> actionList = permissionService.getAllPermission();
        model.addAttribute("actions",actionList);
        List<User> userList = userService.userList();
        model.addAttribute("userList",userList);
        return "administration/account/permission";
    }

    @RequestMapping(value = "/admin/permission", method = RequestMethod.POST,params = "addPermission")
    public String formPermission(){
        return "administration/account/addPermission";
    }
    @RequestMapping(value = "/admin/permission", method = {RequestMethod.POST,RequestMethod.GET},params = {"action","description","add"})
    public String addPermission(Model  model,@RequestParam(value ="action") String action,@RequestParam(value = "description") String description){
        model.addAttribute("action",action);
        model.addAttribute("description",description);
        return "/user/index";
    }
    @RequestMapping(value = "/admin/permission", method = {RequestMethod.POST,RequestMethod.GET},params = "user_id")
    public String updatePermission(Model model, @RequestParam(value = "user_id") Integer id){
        User user = userService.findById(id);
        List<Action> actionList = permissionService.getAllPermission();
        model.addAttribute("actions",actionList);
        model.addAttribute("User",user);
        return "administration/account/permissionUpdate";
    }
    @RequestMapping(value = "/admin/permission/update", method = {RequestMethod.POST,RequestMethod.GET})
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
        return "administration/index" ;
    }
    /*=========================== End Permission ===========================*/
}
