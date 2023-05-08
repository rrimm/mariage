package com.multi.mariage.category.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class DrinkUpperCategoryResponse {
    private List<DrinkUpperCategoryValuesResponse> category;

    public DrinkUpperCategoryResponse(List<DrinkUpperCategoryValuesResponse> category) {
        this.category = category;
    }
}
