package com.example.authority.domain.service;

import com.example.authority.domain.repository.UserRoleRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserRoleServiceTest {
    UserRoleRepository roleRepository;
    UserRoleService userRoleService;


    @Before
    public void setUp() throws Exception {
        roleRepository = mock(UserRoleRepository.class);
        userRoleService = new UserRoleService(roleRepository);

    }

    @Test
    public void findRoleId01() {
        Integer role_id = 2;
        when(roleRepository.findRoleIdByUserId(2)).thenReturn(2);
        Integer result = userRoleService.findRoleId(2);
        assertThat(result, is(role_id));
    }
    @Test
    public void findRoleId02() {
        when(roleRepository.findRoleIdByUserId(2)).thenReturn(null);
        Integer result = userRoleService.findRoleId(2);
        assertThat(result, is(nullValue()));
    }
}