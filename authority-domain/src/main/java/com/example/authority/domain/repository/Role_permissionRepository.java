package com.example.authority.domain.repository;

import com.example.authority.domain.model.RoleAction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface Role_permissionRepository extends JpaRepository<RoleAction,Integer> {
    @Query(value = "select ra from RoleAction ra " +
            "inner join Role r on r.roleId=ra.role.roleId " +
            "inner join Action a on a.id= ra.action.id " +
            "where r.roleId=?1 and a.id=?2 ")
    Optional<RoleAction> findByAction_IdAndRole_Id(Integer role_id,Integer permission_id);
}
