package com.example.devhive_backend.dto;

import com.example.devhive_backend.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private Long id;
    private String name;
    private String image;
    private String quantity;
    private BigDecimal price;
    private Category category;
    private Integer status;
}
