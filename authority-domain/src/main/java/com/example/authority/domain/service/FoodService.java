package com.example.authority.domain.service;

import com.example.authority.domain.model.Food;
import com.example.authority.domain.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FoodService {
    private final FoodRepository foodRepository;
    public List<Food> getAllFood(){
        return foodRepository
                .findAll()
                .stream()
                .collect(Collectors.toList());
    }
}
