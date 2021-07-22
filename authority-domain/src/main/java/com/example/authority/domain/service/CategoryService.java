package com.example.authority.domain.service;

import com.example.authority.domain.exception.BadRequestException;
import com.example.authority.domain.model.Category;
import com.example.authority.domain.model.Food;
import com.example.authority.domain.repository.CategoryRepository;
import com.example.authority.domain.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final FoodRepository foodRepository;
    public List<Category> getAllCategory(){
            return categoryRepository.findAll()
                    .stream()
                    .collect(Collectors.toList());
    }
    public  Category findCateById(Integer id){
        return categoryRepository
                .getOne(id);
    }
    @Transactional
    public void addCate(String name){
        Category category1 = categoryRepository.findByCategoryName(name);
        if(category1!=null){
            throw  new RuntimeException("Category already exist!!");
        }
        Category category = new Category();
        category.setCategoryName(name);
        categoryRepository.save(category);
    }
//    @Transactional
    public void deleteCate(Integer id){
        List<Food> foodList = foodRepository.findByCategorySetId(id);
        if(foodList.size()>0){
            throw new BadRequestException("Balance not enough!");
        }
        categoryRepository.deleteById(id);
    }
    @Transactional
    public void updateCate(Integer id,String name){
        Category category = findCateById(id);
        if (name!=null) {
        category.setCategoryName(name);
        }
        categoryRepository.save(category);
    }
}
