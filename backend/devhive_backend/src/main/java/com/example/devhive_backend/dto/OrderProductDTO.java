package com.example.devhive_backend.dto;

import com.example.devhive_backend.entity.Order;
import com.example.devhive_backend.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderProductDTO {
    private Long id;
    private Integer quantity;
    private BigDecimal price;
    private Order order;
    private Product product;
}
