package com.example.devhive_backend.service.impl;

import com.example.devhive_backend.dto.OrderDTO;
import com.example.devhive_backend.entity.Order;
import com.example.devhive_backend.repository.OrderRepository;
import com.example.devhive_backend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.devhive_backend.mapper.OrderMapper.mapToOrder;
import static com.example.devhive_backend.mapper.OrderMapper.mapToOrderDTO;

@Service
public class OrderServiceIpml implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<OrderDTO> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream().map((order) -> mapToOrderDTO(order)).collect(Collectors.toList());
    }

    @Override
    public OrderDTO getOrderById(Long id) {
        Order order =  orderRepository.findById(id).get();
        return mapToOrderDTO(order);
    }

    @Override
    public Order createOrder(OrderDTO orderDTO) {
        Order order = mapToOrder(orderDTO);
        return orderRepository.save(order);
    }

    @Override
    public void updateOrder(OrderDTO orderDTO) {
        Order order = mapToOrder(orderDTO);
        orderRepository.save(order);
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
