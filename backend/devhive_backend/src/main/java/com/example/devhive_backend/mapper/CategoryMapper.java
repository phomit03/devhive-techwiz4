package com.example.devhive_backend.mapper;

import com.example.devhive_backend.dto.CategoryDTO;
import com.example.devhive_backend.entity.Category;

import java.util.stream.Collectors;

import static com.example.devhive_backend.mapper.ProductMapper.mapToProductDTO;

public class CategoryMapper {
    //  categoryDto sang Category.
    public static Category mapToCategory(CategoryDTO categoryDTO) {
        Category category = Category.builder()
                .id(categoryDTO.getId())
                .name(categoryDTO.getName())
                .build();
        return category;
    }
        // category qua dto
    public static CategoryDTO mapToCategoryDto(Category category) {
        CategoryDTO categoryDTO =CategoryDTO.builder()
                .id(category.getId())
                .name(category.getName())
//                .products(category.getProducts().stream().map((product) -> mapToProductDTO(product)).collect(Collectors.toList()))
                .build();
        return categoryDTO;
    }
}