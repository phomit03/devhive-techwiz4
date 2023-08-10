package com.example.devhive_backend.service;

import com.example.devhive_backend.dto.CategoryDTO;
import com.example.devhive_backend.entity.Category;
import com.example.devhive_backend.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CategoryService {

    List<CategoryDTO> getAllCategories();

    CategoryDTO getCategoryById(Long id);

    Category createCategory(CategoryDTO categoryDTO);


    // Category updateCategory(Long id, Category category);

  //  void deleteCategory(Long id);
}