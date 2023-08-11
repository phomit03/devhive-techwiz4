package com.example.devhive_backend.service.impl;

import com.example.devhive_backend.dto.CategoryDTO;
import com.example.devhive_backend.entity.Category;
import com.example.devhive_backend.repository.CategoryRepository;
import com.example.devhive_backend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.devhive_backend.mapper.CategoryMapper.mapToCategory;
import static com.example.devhive_backend.mapper.CategoryMapper.mapToCategoryDto;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<CategoryDTO> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().map((category) -> mapToCategoryDto(category)).collect(Collectors.toList());
    }

    @Override
    public CategoryDTO getCategoryById(Long id) {
        Category category =  categoryRepository.findById(id).get();
        return mapToCategoryDto(category);
    }


    @Override
    public Category createCategory(CategoryDTO categoryDTO) {
        Category category = mapToCategory(categoryDTO);
        return categoryRepository.save(category);
    }

    @Override
    public void updateCategory(CategoryDTO categoryDTO) {
        Category category = mapToCategory(categoryDTO);
        categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
