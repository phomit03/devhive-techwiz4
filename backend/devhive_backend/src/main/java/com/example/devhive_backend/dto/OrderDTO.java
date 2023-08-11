package com.example.devhive_backend.dto;

import com.example.devhive_backend.entity.OrderProduct;
import com.example.devhive_backend.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private Long id;
    private User user;
    private BigDecimal totalPrice;
    private Integer status;
    private List<OrderProductDTO> orderProducts;

}
