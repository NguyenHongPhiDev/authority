package com.example.authority.domain.service;

import com.example.authority.domain.model.Action;
import com.example.authority.domain.model.Role;
import com.example.authority.domain.repository.PermissionRepository;
import com.example.authority.domain.repository.RoleRepository;
import com.example.authority.domain.repository.Role_permissionRepository;
import org.junit.Before;
import org.junit.Test;
import org.terasoluna.gfw.common.exception.ResourceNotFoundException;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PermissionServiceTest {
    RoleService roleService;
    PermissionService permissionService;
    RoleRepository roleRepository;
    PermissionRepository permissionRepository;
    Role_permissionRepository role_permissionRepository;

    @Before
    public void setUp() throws Exception {
        roleRepository = mock(RoleRepository.class);
        permissionRepository = mock(PermissionRepository.class);
        role_permissionRepository = mock(Role_permissionRepository.class);
        roleService = new RoleService(roleRepository);
        permissionService = new PermissionService(permissionRepository,role_permissionRepository,roleService);
    }

    @Test
    public void insert_roleNull() {
        Integer role_id = 1,user_id = 1;
        Action action = new Action();
        when(roleRepository.findById(role_id)).thenReturn(Optional.empty());
        when(permissionRepository.findById(user_id)).thenReturn(Optional.of(action));
        assertThrows(ResourceNotFoundException.class,()->{
           roleService.findRoleById(role_id);
        });
    }
    @Test
    public void insert_actionNull() {
        Integer role_id = 1,user_id = 1;
        Role role = new Role();
        when(roleRepository.findById(role_id)).thenReturn(Optional.of(role));
        when(permissionRepository.findById(user_id)).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class,()->{
            permissionService.findPermissionById(role_id);
        });
    }
    @Test
    public void insert_success() {
        Integer role_id = 1,user_id = 1;
        Action action = new Action();
        Role role = new Role();
        when(roleRepository.findById(role_id)).thenReturn(Optional.of(role));
        when(permissionRepository.findById(user_id)).thenReturn(Optional.of(action));
        assertDoesNotThrow(()-> permissionService.Insert(role_id,user_id));

    }
}