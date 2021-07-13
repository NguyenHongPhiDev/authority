package com.example.authority.domain.repository;

import com.example.authority.domain.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role,Integer> {
    @Query(value = "SELECT r.roleName as role from Role r join" +
            " RoleAction ra on ra.role.roleId = r.roleId" +
            " join Action a on a.id = ra.action.id" +
            " where a.name = ?1")
    List<String> findByRoleActions(String url);
}
