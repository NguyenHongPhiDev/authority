package com.example.authority.domain.repository;

import com.example.authority.domain.model.Role;
import com.example.authority.domain.model.RoleAction;
import com.example.authority.domain.model.UrlRolesBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role,Integer> {
//    @Query(value = "SELECT ra.action.name AS url ,ra.role.roleName AS role " +
//            "FROM RoleAction ra join Role r" +
//            " ON ra.role.roleId = r.roleId " +
//            "JOIN Action a ON a.id=ra.action.id")
//    List<Role> findByRoleActions();
}
