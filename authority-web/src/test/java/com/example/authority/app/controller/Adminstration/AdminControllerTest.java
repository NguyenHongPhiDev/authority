package com.example.authority.app.controller.Adminstration;

import com.example.authority.app.controller.User.UserController;
import com.example.authority.domain.model.Food;
import com.example.authority.domain.repository.CategoryRepository;
import com.example.authority.domain.repository.FoodRepository;
import com.example.authority.domain.service.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class AdminControllerTest {
    private final String ADMIN = "administration/index";
    private final String FOOD = "administration/product/Food";
    private final String CREATEFOOD = "administration/product/createFood";
    //    private final String ADMIN = "administration/index";
    UserService userService;
    FoodService foodService;
    PermissionService permissionService;
    UserRoleService userRoleService;
    @InjectMocks
    private MockMvc mockMvc;
    FoodRepository foodRepository;
    AdminController adminController;
    CategoryService categoryService;
    CategoryRepository categoryRepository;
    @Before
    public void setUp() {
        foodRepository = mock(FoodRepository.class);
        foodService = mock(FoodService.class);
        foodService = new FoodService(foodRepository,categoryService);
        categoryRepository = mock(CategoryRepository.class);
        categoryService= new CategoryService(categoryRepository);
        adminController = new AdminController(userService, foodService, permissionService, userRoleService,categoryService);
        mockMvc = MockMvcBuilders.standaloneSetup(adminController).build();
    }

    @Test
    public void viewAdmin() {
        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/admin")).andExpect(view().name(ADMIN));
            return;
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void selectFood() {
        List<Food> list = new ArrayList<>();
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/admin/food");
        when(foodRepository.findAll()).thenReturn(list);
        when(foodService.getAllFood()).thenReturn(list);
        List<Food> foodList = foodService.getAllFood();
        try {
            ResultActions actions = mockMvc.perform(request);
            actions.andExpect(view().name(FOOD));
            actions.andExpect(model().attribute("food", foodList));
        } catch (Exception e) {
             fail();
        }
    }

    @Test
    public void CreateFood() {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/admin/food").param("addFood","");
        try {
            ResultActions actions = mockMvc.perform(request);
            actions.andExpect(view().name(CREATEFOOD));
            return;
        } catch (Exception e) {
            e.printStackTrace();
        }
        fail();
    }
}