package com.example.authority.domain.Dto.request;

import com.example.authority.domain.model.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodRequest {
    private Integer id;
    private String food_Name;
    private String amount;
    private Category category;
}
