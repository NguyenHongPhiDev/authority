package com.example.authority.app.controller.Adminstration;

import com.example.authority.app.controller.User.UserController;
import com.example.authority.domain.service.FoodService;
import com.example.authority.domain.service.PermissionService;
import com.example.authority.domain.service.UserRoleService;
import com.example.authority.domain.service.UserService;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class AdminControllerTest {
    private static final String ADMIN = "administration/index";
    @InjectMocks
    private  UserService userService ;
    @InjectMocks
    private  FoodService foodService;
    @InjectMocks
    private  PermissionService permissionService ;
    @InjectMocks
    private  UserRoleService userRoleService;
    @InjectMocks
    private MockMvc mockMvc;
    @Mock
    private final AdminController adminController = new AdminController(userService,foodService,permissionService,userRoleService);
    @Test
    public void viewAdmin() {
        mockMvc = MockMvcBuilders.standaloneSetup(adminController).build();
        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/admin")).andExpect(view().name(ADMIN));
            return;
        } catch (Exception e) {
            fail();
        }
    }
}