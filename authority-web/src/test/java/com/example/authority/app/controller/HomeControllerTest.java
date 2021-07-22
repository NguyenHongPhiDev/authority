package com.example.authority.app.controller;

import com.example.authority.app.controller.User.HomeController;
import com.example.authority.app.security.RestFB;
import com.example.authority.domain.model.UserRole;
import com.example.authority.domain.repository.UserRepository;
import com.example.authority.domain.service.UserService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.*;

import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


public class HomeControllerTest {

    private static final String HOME = "layout/index";
    @Mock
    private UserRole userRole;
    @InjectMocks
    private UserService userService;
    @InjectMocks
    private RestFB restFBl;
    @InjectMocks
    private MockMvc mockMvc;
    @InjectMocks
    private UserRepository userRepository;
    @Mock
    private Set<UserRole> userRoles;
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void home() throws Exception {
        HomeController homeController = new HomeController();
        mockMvc = MockMvcBuilders.standaloneSetup(homeController).build();
        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/")).andExpect(view().name(HOME));
            return;
        } catch (Exception e) {
            fail();
        }
    }
}