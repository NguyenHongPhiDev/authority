package com.example.authority.domain.service;

import com.example.authority.domain.model.Role;
import com.example.authority.domain.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.terasoluna.gfw.common.exception.ResourceNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public Role findRoleById(Integer id) {
        return roleRepository
                .findById(id)
                .orElseGet(() -> {
                    log.warn("Role not found. Role_id {}", id);
                    throw new ResourceNotFoundException("Role not found. Role_id: " + id);
                });
    }
}
