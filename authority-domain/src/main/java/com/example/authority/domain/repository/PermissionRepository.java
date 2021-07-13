package com.example.authority.domain.repository;

import com.example.authority.domain.model.Action;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PermissionRepository extends JpaRepository<Action,Integer> {
    @Query(value = "select a from Action a")
    List<Action> findAllPermission();
}
