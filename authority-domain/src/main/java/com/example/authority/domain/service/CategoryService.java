package com.example.authority.domain.service;

import com.example.authority.domain.model.Category;
import com.example.authority.domain.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    public List<Category> getAllCategory(){
            return categoryRepository.findAll()
                    .stream()
                    .collect(Collectors.toList());
    }
    public  Category findCateById(Integer id){
        return categoryRepository
                .getOne(id);
    }
}
