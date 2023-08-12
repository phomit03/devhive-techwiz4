package com.example.devhive_backend.mapper;

import com.example.devhive_backend.dto.ProductDTO;
import com.example.devhive_backend.entity.Product;
import com.example.devhive_backend.utils.UploadImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

public class ProductMapper {
    public static Product mapToProduct(ProductDTO productDTO) {
        return Product.builder()
                .id(productDTO.getId())
                .name(productDTO.getName())
                .image(productDTO.getImage())
                .quantity(productDTO.getQuantity())
                .price(productDTO.getPrice())
                .category(productDTO.getCategory())
                .status(productDTO.getStatus())
                .build();
    }

    public static ProductDTO mapToProductDTO(Product product) {
        return ProductDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .image(product.getImage())
                .quantity(product.getQuantity())
                .price(product.getPrice())
                .category(product.getCategory())
                .status(product.getStatus())
                .build();
    }
}