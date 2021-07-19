package com.example.authority.domain.service;

import com.example.authority.domain.model.Action;
import com.example.authority.domain.model.Role;
import com.example.authority.domain.model.RoleAction;
import com.example.authority.domain.repository.PermissionRepository;
import com.example.authority.domain.repository.Role_permissionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.terasoluna.gfw.common.exception.ResourceNotFoundException;

import javax.persistence.Id;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class PermissionService {
    private final PermissionRepository permissionRepository;
    private final Role_permissionRepository role_permissionRepository;
    private final RoleService roleService ;

    public List<Action> getAllPermission() {
        return permissionRepository
                .findAllPermission()
                .stream()
                .collect(Collectors.toList());
    }
    public Action findPermissionById(Integer id){
        return permissionRepository
                .findById(id)
                .orElseGet(() -> {
                    log.warn("Permission not found. Permission_id {}", id);
                    throw new ResourceNotFoundException("Permission not found. Permission_id: " + id);
                });
    }

    @Transactional
    public void Insert(Integer role_id, Integer permission_id) {
        RoleAction roleAction= new RoleAction();
        roleAction.setRole(roleService.findRoleById(role_id));
        roleAction.setAction(findPermissionById(permission_id));
        role_permissionRepository.save(roleAction);
    }
    @Transactional
    public void Delete(Integer role_id, Integer permission_id) {
        Optional<RoleAction> action = role_permissionRepository.findByAction_IdAndRole_Id(role_id,permission_id);
        role_permissionRepository.deleteById(action.get().getId());
    }
}
