package com.example.authority.domain.repository;

import com.example.authority.domain.model.Action;
import com.example.authority.domain.service.PermissionService;
import com.example.authority.domain.service.RoleService;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.hamcrest.MatcherAssert.assertThat;

public class PermissionRepositoryTest {
    PermissionRepository permissionRepository;
    PermissionService permissionService ;
    Role_permissionRepository role_permissionRepository ;
    RoleService roleService;

    @Before
    public void setUp() throws Exception {
        permissionRepository = mock(PermissionRepository.class);
        permissionService = new PermissionService(permissionRepository,role_permissionRepository,roleService);
    }

    @Test
    public void findAllPermission() {
        List<Action> actions = permissionRepository.findAllPermission();
        assertThat(actions,is(notNullValue()));
    }
}