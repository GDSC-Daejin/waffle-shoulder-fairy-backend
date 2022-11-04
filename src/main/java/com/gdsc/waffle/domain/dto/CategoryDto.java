package com.gdsc.waffle.domain.dto;

import com.gdsc.waffle.domain.entity.CategoryEntity;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class CategoryDto {
    private Long id;
    private String category;

    public static CategoryDto createCategoryDto(CategoryEntity category) {
        return new CategoryDto(
                category.getId(),
                category.getCategory()
        );
    }

    public CategoryEntity toEntity() {
        return new CategoryEntity(id,category);
    }
}
