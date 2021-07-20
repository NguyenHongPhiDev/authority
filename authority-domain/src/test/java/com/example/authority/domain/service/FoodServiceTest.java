package com.example.authority.domain.service;

import com.example.authority.domain.model.Category;
import com.example.authority.domain.model.Food;
import com.example.authority.domain.repository.CategoryRepository;
import com.example.authority.domain.repository.FoodRepository;

import org.junit.Before;
import org.junit.Test;

import javax.validation.constraints.NotNull;
import java.util.*;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.hamcrest.MatcherAssert.assertThat;

public class FoodServiceTest {
    FoodService foodService;
    FoodRepository foodRepository;
    CategoryService categoryService;

    @Before
    public void setUp() throws Exception {
        foodRepository = mock(FoodRepository.class);
        foodService = new FoodService(foodRepository,categoryService);
    }

    @Test
    public void getAllFood() {
        List<Food> foodList = new ArrayList<>();
        when(foodRepository.findAll()).thenReturn(foodList);
        when(foodService.getAllFood()).thenReturn(foodList);
        List<Food>result = foodService.getAllFood();
        assertThat(result,is(notNullValue()));
        assertThat(result.size(),is(0));
    }
}