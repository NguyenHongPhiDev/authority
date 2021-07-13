package com.example.authority.domain.repository;

import com.example.authority.domain.model.Action;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Action,Integer> {
}
