package com.example.authority.domain.repository;

import com.example.authority.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,Integer> {
    @Query(value = "SELECT u FROM User u" +
            " join fetch u.userRoles ur" +
            " join fetch ur.role " +
            "where u.username=?1")
    User findUserByUsername(String username);
}
