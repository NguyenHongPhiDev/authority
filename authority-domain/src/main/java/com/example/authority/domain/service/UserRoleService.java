package com.example.authority.domain.service;

import com.example.authority.domain.model.UserRole;
import com.example.authority.domain.repository.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserRoleService {
    private final UserRoleRepository roleRepository;

    public Integer findRoleId(Integer userId) {
        return roleRepository.findRoleIdByUserId(userId);
    }
}
