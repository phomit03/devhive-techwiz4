package com.example.devhive_backend.mapper;

import com.example.devhive_backend.dto.OrderProductDTO;
import com.example.devhive_backend.entity.OrderProduct;

public class OrderProductMapper {
    public static OrderProduct mapToOrderProduct(OrderProductDTO orderProductDTO) {
        OrderProduct orderProduct = OrderProduct.builder()
                .id(orderProductDTO.getId())
                .quantity(orderProductDTO.getQuantity())
                .price(orderProductDTO.getPrice())
                .order(orderProductDTO.getOrder())
                .product(orderProductDTO.getProduct())
                .build();
        return orderProduct;
    }

    public static OrderProductDTO mapToOrderProductDTO(OrderProduct orderProduct) {
        OrderProductDTO orderProductDTO = OrderProductDTO.builder()
                .id(orderProduct.getId())
                .quantity(orderProduct.getQuantity())
                .price(orderProduct.getPrice())
                .order(orderProduct.getOrder())
                .product(orderProduct.getProduct())
                .build();
        return orderProductDTO;
    }
}
