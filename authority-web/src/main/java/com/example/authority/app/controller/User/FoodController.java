package com.example.authority.app.controller.User;

import com.example.authority.domain.model.Food;
import com.example.authority.domain.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class FoodController {
    private final FoodService foodService;

    @GetMapping("/food")
    public String  selectFood(Model model){
        List<Food> foodList = foodService.getAllFood();
        model.addAttribute("food",foodList);
        return "products/foods";
    }
//    @GetMapping(value = "/",params = "create")
//    public String  createFood(Model model){
//        List<Food> foodList = foodService.getAllFood();
//        model.addAttribute("food",foodList);
//        return "products/createFoods";
//    }
}
