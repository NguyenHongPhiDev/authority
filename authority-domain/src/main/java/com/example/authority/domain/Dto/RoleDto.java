package com.example.authority.domain.Dto;

import com.example.authority.domain.model.RoleAction;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class RoleDto {
    private String roleName;
    private String action;

    public void getRoleName(String roleName) {
    }

    public void getAction(Set<RoleAction> roleActions) {
    }
}
