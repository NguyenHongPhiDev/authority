package com.example.authority.domain.service;

import com.example.authority.domain.model.Role;
import com.example.authority.domain.model.RoleAction;
import com.example.authority.domain.model.UserRole;
import com.example.authority.domain.repository.RoleRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.terasoluna.gfw.common.exception.ResourceNotFoundException;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.jupiter.api.Assertions;

import javax.persistence.Id;


public class RoleServiceTest {

    private RoleRepository roleRepository;
    private RoleService roleService;

    @Before
    public void setUp() throws Exception {
        roleRepository = mock(RoleRepository.class);
        roleService = new RoleService(roleRepository);
    }

    @Test
    public void findRoleById_success() {
        Role role = new Role();
        Set<RoleAction> roleAction = new HashSet<>();
        Set<UserRole> userRole = new HashSet<>();
        role.setRoleId(1);
        role.setRoleName("xxx");
        role.setRoleActions(roleAction);
        role.setUserRoles(userRole);
        when(roleRepository.findById(1)).thenReturn(Optional.of(role));
        Role result = roleService.findRoleById(1);
        assertThat(result, is(role));

    }

    @Test
    public void findRoleById_notfound() throws Exception {
        int id = 2;
        when(roleRepository.findById(id)).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> roleService.findRoleById(id));
    }
}