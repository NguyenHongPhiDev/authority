package com.example.authority.domain.repository;

import com.example.authority.domain.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food,Integer> {
}
