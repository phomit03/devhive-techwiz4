package com.example.devhive_backend.service;

import com.example.devhive_backend.dto.ProductDTO;
import com.example.devhive_backend.entity.Product;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService{
    List<ProductDTO> getAllProducts();

    ProductDTO getProductById(Long id);

    Product createProduct(ProductDTO productDTO, MultipartFile image);

    void updateProduct(ProductDTO productDTO, MultipartFile image);

    void deleteProduct(Long id);
}
