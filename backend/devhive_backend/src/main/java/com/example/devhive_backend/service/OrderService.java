package com.example.devhive_backend.service;

import com.example.devhive_backend.dto.OrderDTO;
import com.example.devhive_backend.entity.Order;

import java.util.List;

public interface OrderService {
    List<OrderDTO> getAllOrders();

    OrderDTO getOrderById(Long id);

    Order createOrder(OrderDTO orderDTO);

    void updateOrder(OrderDTO orderDTO);

    void deleteOrder(Long id);
}
