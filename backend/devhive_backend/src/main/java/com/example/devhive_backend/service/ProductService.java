package com.example.devhive_backend.service;

import com.example.devhive_backend.dto.ProductDTO;
import com.example.devhive_backend.entity.Product;

import java.util.List;

public interface ProductService{
    List<ProductDTO> getAllProducts();

    ProductDTO getProductById(Long id);

    Product createProduct(ProductDTO productDTO);

    void updateProduct(ProductDTO productDTO);

    void deleteProduct(Long id);
}
