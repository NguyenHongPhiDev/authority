package com.example.authority.app.controller.User;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class UserControllerTest {
    private static final String USER = "user/index";
    @InjectMocks
    private MockMvc mockMvc;
    @Test
    public void viewProfile() throws  Exception {
        UserController userController = new UserController();
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/user")).andExpect(view().name(USER));
            return;
        } catch (Exception e) {
            fail();
        }
    }
}