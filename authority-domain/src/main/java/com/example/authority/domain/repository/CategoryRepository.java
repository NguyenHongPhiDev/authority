package com.example.authority.domain.repository;

import com.example.authority.domain.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
    @Query
    Category findByCategoryName(String name);
    @Query(value = "delete from Category c where c.id=?1")
    void deleteCategoryId(Integer id);
}
