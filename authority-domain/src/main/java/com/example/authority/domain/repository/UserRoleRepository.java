package com.example.authority.domain.repository;

import com.example.authority.domain.model.UserRole;
import org.hibernate.mapping.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRoleRepository extends JpaRepository<UserRole ,Integer> {
    @Query(value = "select ur.role.roleId from UserRole ur" +
            " where ur.user.id =?1")
    Integer findRoleIdByUserId(Integer user_id);
}
