package com.example.authority.domain.service;

import com.example.authority.domain.Dto.request.FoodRequest;
import com.example.authority.domain.model.Category;
import com.example.authority.domain.model.Food;
import com.example.authority.domain.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.terasoluna.gfw.common.exception.ResourceNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FoodService {
    private final FoodRepository foodRepository;
    private final CategoryService categoryService;

    public List<Food> getAllFood() {
        return foodRepository
                .findAll()
                .stream()
                .collect(Collectors.toList());
    }

    public Food getFoodById(Integer id) {
        return foodRepository.getOne(id);
    }

    @Transactional
    public void addFood(String name, Integer Amount, Integer cate_id) {
        Food food = new Food();
        Category category = categoryService.findCateById(cate_id);
        if (category == null) {
            throw new ResourceNotFoundException("Category not found, category_id : " + cate_id);
        }
        food.setFoodName(name);
        food.setAmount(Amount);
        food.setCategorySet(category);
        foodRepository.save(food);
    }

    @Transactional
    public void deleteFood(Integer id) {
        foodRepository.deleteById(id);
    }

    @Transactional
    public void updateFood(Integer id, String name, Integer amount, Integer cate_id) {
        Food food = getFoodById(id);
        if (food == null) {
            throw new ResourceNotFoundException("Food not found, food_id : " + id);
        }
        Category category = categoryService.findCateById(cate_id);
        if (category == null) {
            throw new ResourceNotFoundException("Category not found, category_id : " + cate_id);
        }
        if (name != null) {
            food.setFoodName(name);
        }
        if (amount != null) {
            food.setAmount(amount);
        }
        food.setCategorySet(category);
        foodRepository.save(food);
    }
}
