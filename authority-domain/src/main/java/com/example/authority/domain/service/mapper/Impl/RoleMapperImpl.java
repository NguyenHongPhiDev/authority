package com.example.authority.domain.service.mapper.Impl;

import com.example.authority.domain.Dto.RoleDto;
import com.example.authority.domain.model.Role;
import com.example.authority.domain.service.mapper.RoleMapper;
import org.springframework.stereotype.Component;


@Component
public class RoleMapperImpl implements RoleMapper {
    @Override
    public RoleDto toRoleDto(Role role) {

        if ( role == null ) {
            return null;
        }

        RoleDto roleDto = new RoleDto();

        roleDto.getRoleName(role.getRoleName());
        roleDto.getAction(role.getRoleActions());

        return roleDto;
    }
}
