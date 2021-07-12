package com.example.authority.domain.service.mapper;

import com.example.authority.domain.Dto.RoleDto;
import com.example.authority.domain.model.Role;

public interface RoleMapper {
    RoleDto toRoleDto(Role role);
}
