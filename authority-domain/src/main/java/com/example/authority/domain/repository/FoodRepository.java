package com.example.authority.domain.repository;

import com.example.authority.domain.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food,Integer> {
    @Query(value = "select f from Food f where f.categorySet.id=?1")
    List<Food> findByCategorySetId(Integer id);
}
