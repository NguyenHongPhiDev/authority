package com.example.authority.domain.service;

import com.example.authority.domain.model.Action;
import com.example.authority.domain.repository.PermissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PermissionService {
    private final PermissionRepository permissionRepository;
    public List<Action> getAllPermission(){
        return permissionRepository
                .findAll()
                .stream()
                .collect(Collectors.toList());
    }
}
