package com.example.authority.domain.service;

import com.example.authority.domain.model.User;
import com.example.authority.domain.model.UserRole;
import com.example.authority.domain.repository.UserRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.terasoluna.gfw.common.exception.ResourceNotFoundException;

import java.util.*;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.mock;


import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class UserServiceTest {
    UserRepository userRepository;
    UserService userService;

    @Before
    public void setUp() throws Exception {
        userService = mock(UserService.class);
        userRepository = mock(UserRepository.class);
        userService = new UserService(userRepository);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void userList() {
        Set<UserRole> userRoleSet = new HashSet<>();
        List<User> userList = Arrays.asList(
                new User("admin", "{pbkdf2}1dd84f42a7a9a173f8f806d736d34939bed6a36e2948e8bfe88801ee5e6e61b815efc389d03165a4", userRoleSet),
                new User("staff", "{pbkdf2}1dd84f42a7a9a173f8f806d736d34939bed6a36e2948e8bfe88801ee5e6e61b815efc389d03165a4", userRoleSet),
                new User("user", "{pbkdf2}1dd84f42a7a9a173f8f806d736d34939bed6a36e2948e8bfe88801ee5e6e61b815efc389d03165a4", userRoleSet)
        );
        when(userRepository.findAll()).thenReturn(userList);
        when(userService.userList()).thenReturn(userList);

        List<User> result = userService.userList();
        assertThat(result, is(notNullValue()));
        assertThat(result.size(), is(3));
    }

    @Test
    public void findById01() {
        User user = new User();
        when(userRepository.findById(1)).thenReturn(Optional.of(user));
        User result = userService.findById(1);
        assertThat(result, is(user));
    }

    @Test
    public void findById02() {
        Integer id = 1;
        when(userRepository.findById(id)).thenReturn(Optional.empty());
        User result = userService.findById(id);
//        assertThat(result, is(nullValue()));
        assertNull(result);
    }
}