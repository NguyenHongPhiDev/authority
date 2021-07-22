package com.example.authority.app.controller.Adminstration;

import com.example.authority.domain.model.Category;
import com.example.authority.domain.repository.CategoryRepository;
import com.example.authority.domain.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    @GetMapping("/admin/category")
    public String viewCategory(Model model){
        List<Category> categoryList = categoryService.getAllCategory();
        model.addAttribute("categories",categoryList);
        return "administration/product/category";
    }
    @RequestMapping(value = "/admin/category",params = "addCategory")
    public String formAddCate(){
        return "administration/product/createCategory";
    }
    @RequestMapping(value = "/admin/category",params = {"addCate","name"})
    public String AddCate(Model model,@RequestParam(value = "name") String name){
        categoryService.addCate(name);
        return viewCategory(model);
    }
    @RequestMapping(value = "/admin/category",method = RequestMethod.POST,params = "delete_id")
    public String deleteCate(Model model,@RequestParam(value = "delete_id") Integer id){
        categoryService.deleteCate(id);
        return viewCategory(model);
    }
    @RequestMapping(value = "/admin/category",params = "update_id")
    public String formUpdateCate(Model model, @RequestParam(value = "update_id") Integer id){
        Category categoryList = categoryService.findCateById(id);
        model.addAttribute("categories",categoryList);
        return "administration/product/updateCategory";
    }
    @RequestMapping(value = "/admin/category",params = {"updateCate","id","name"})
    public String UpdateCate(Model model,@RequestParam(value = "id") Integer id,@RequestParam(value = "name") String name){
        categoryService.updateCate(id,name);
        return viewCategory(model);
    }
}
