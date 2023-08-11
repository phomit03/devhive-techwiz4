package com.example.devhive_backend.service;

import com.example.devhive_backend.dto.OrderProductDTO;
import com.example.devhive_backend.entity.OrderProduct;

import java.util.List;

public interface OrderProductService {
    List<OrderProductDTO> getAllOrderProducts();

    OrderProductDTO getOrderProductById(Long id);

    OrderProduct createOrderProduct(OrderProductDTO orderProductDTO);

    void updateOrderProduct(OrderProductDTO orderProductDTO);

    void deleteOrderProduct(Long id);
}
