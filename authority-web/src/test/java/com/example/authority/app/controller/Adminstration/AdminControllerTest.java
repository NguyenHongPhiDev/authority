package com.example.authority.app.controller.Adminstration;

import com.example.authority.domain.model.Category;
import com.example.authority.domain.model.Food;
import com.example.authority.domain.service.*;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.terasoluna.gfw.common.exception.ResourceNotFoundException;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class AdminControllerTest {
    private final String ADMIN = "administration/index";
    private final String FOOD = "administration/product/food";
    private final String CREATEFOOD = "administration/product/createFood";
    private final String UPDATEFOOD = "administration/product/updateFood";
    UserService userService;
    FoodService foodService;
    PermissionService permissionService;
    UserRoleService userRoleService;
    MockMvc mockMvc;
    AdminController adminController;
    CategoryService categoryService;

    @Before
    public void setUp() {
        foodService = mock(FoodService.class);
        categoryService = mock(CategoryService.class);
        adminController = new AdminController(userService, foodService, permissionService, userRoleService, categoryService);
        mockMvc = MockMvcBuilders.standaloneSetup(adminController).build();
    }

    @Test
    public void viewAdmin() {
        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/admin"))
                    .andExpect(view().name(ADMIN));
            return;
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void selectFood() {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/admin/food");
        List<Food> foodList = foodService.getAllFood();
        try {
            ResultActions actions = mockMvc.perform(request);
            actions.andExpect(view().name(FOOD));
            actions.andExpect(status().isOk());
            actions.andExpect(model().attribute("food", foodList));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void CreateFood() {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/admin/food").param("addFood", "");
        List<Category> categoryList = categoryService.getAllCategory();
        try {
            ResultActions actions = mockMvc.perform(request);
            actions.andExpect(view().name(CREATEFOOD));
            actions.andExpect(model().attribute("categories", categoryList));
            return;
        } catch (Exception e) {
            e.printStackTrace();
        }
        fail();
    }

    @Test
    public void addFood_fail() {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/admin/food")
                .param("add", "");
        request.param("name", "xxx");
        request.param("amount", "12000");
        request.param("category", (String) null);
        doThrow(new  RuntimeException("Category not found!!")).when(foodService).addFood("xxx",10000,null);
        try {
            ResultActions actions = mockMvc.perform(request);
            actions.andExpect(status().is(400));
            return;
        } catch (Exception e) {
            e.printStackTrace();
        }
        fail();
    }
    @Test
    public void addFood() {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/admin/food")
                .param("add", "");
        request.param("name", "xxx");
        request.param("amount", "12000");
        request.param("category", "3");
        doNothing().when(foodService).addFood("xxx",10000,3);
        try {
            ResultActions actions = mockMvc.perform(request);
            actions.andExpect(status().isOk());
            actions.andExpect(view().name(FOOD));
            return;
        } catch (Exception e) {
            e.printStackTrace();
        }
        fail();
    }

    @Test
    public void deleteFood() {
        Integer delete_id = 3;
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/admin/food").param("delete_id", delete_id.toString());
        try {
            mockMvc.perform(request);
            assertDoesNotThrow(() -> foodService.deleteFood(delete_id));
            return;
        } catch (Exception e) {
            e.printStackTrace();
        }
        fail();
    }

    @Test
    public void updateFoodForm() {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/admin/food").param("update_id", "3");
        Food food = foodService.getFoodById(3);
        List<Category> categoryList = categoryService.getAllCategory();
        try {
            ResultActions actions = mockMvc.perform(request);
            actions.andExpect(view().name(UPDATEFOOD));
            actions.andExpect(model().attribute("food",food));
            actions.andExpect(model().attribute("categories", categoryList));
            return;
        } catch (Exception e) {
            e.printStackTrace();
        }
        fail();
    }

    @Test
    public void updateFood_FailIdNull() {
        Integer id_update = null;
        String  name_update = "xxx";
        Integer amount_update=12000;
        Integer category_id = 3;
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/admin/food")
                .param("update", "");
        request.param("id", (String) null);
        request.param("name", "xxx");
        request.param("amount", "12000");
        request.param("category", "3");
        doThrow(new ResourceNotFoundException("Id is not null!!!")).when(foodService).updateFood(id_update,name_update,amount_update,category_id);
        try {
            ResultActions results = mockMvc.perform(request);
            results.andExpect(status().is(400));
            return;
        } catch (Exception e) {
            e.printStackTrace();
        }
        fail();
    }

    @Test
    public void updateFood_FailCateNull() {
        Integer id_update = 2;
        String name_update = "xxx";
        Integer amount_update = 12000;
        Integer category_id = null;
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/admin/food")
                .param("update", "");
        request.param("id", "2");
        request.param("name", "xxx");
        request.param("amount", "12000");
        request.param("category", (String) null);
        doThrow(new ResourceNotFoundException("Cate is not null!!!")).when(foodService).updateFood(id_update, name_update, amount_update, category_id);
        try {
            ResultActions results = mockMvc.perform(request);
            results.andExpect(status().is(400));
            return;
        } catch (Exception e) {
            e.printStackTrace();
        }
        fail();
    }

    @Test
    public void updateFood_Success() {
        Integer id_update = 2;
        String name_update = "xxx";
        Integer amount_update = 12000;
        Integer category_id = 3;
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/admin/food")
                .param("update", "");
        request.param("id", "2");
        request.param("name", "xxx");
        request.param("amount", "12000");
        request.param("category", "3");
        doNothing().when(foodService).updateFood(id_update, name_update, amount_update, category_id);
        try {
            ResultActions results = mockMvc.perform(request);
            results.andExpect(status().isOk());
            results.andExpect(view().name(FOOD));
            return;
        } catch (Exception e) {
            e.printStackTrace();
        }
        fail();
    }
}