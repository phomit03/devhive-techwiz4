package com.example.devhive_backend.mapper;

import com.example.devhive_backend.dto.ProductDTO;
import com.example.devhive_backend.entity.Product;
import com.example.devhive_backend.utils.UploadImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

public class ProductMapper {
    @Autowired
    private static UploadImage uploadImage;
    public static Product mapToProduct(ProductDTO productDTO, MultipartFile image) {
        Product.ProductBuilder productBuilder = Product.builder()
                .id(productDTO.getId())
                .name(productDTO.getName())
                .quantity(productDTO.getQuantity())
                .price(productDTO.getPrice())
                .category(productDTO.getCategory())
                .status(productDTO.getStatus());

        String imagePath = uploadImage.uploadImage(image);
        if (imagePath != null) {
            productBuilder.image(imagePath);
        } else {
            productBuilder.image(productDTO.getImage());
        }

        return productBuilder.build();
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