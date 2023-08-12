package com.example.devhive_backend.service;

import com.example.devhive_backend.dto.CategoryDTO;
import com.example.devhive_backend.entity.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategories();

    CategoryDTO getCategoryById(Long id);

    Category createCategory(CategoryDTO categoryDTO);


    void updateCategory(CategoryDTO categoryDTO);
    void deleteCategory(Long id);
}