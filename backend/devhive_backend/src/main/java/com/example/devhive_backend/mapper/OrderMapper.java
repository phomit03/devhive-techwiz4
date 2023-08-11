package com.example.devhive_backend.mapper;

import com.example.devhive_backend.dto.OrderDTO;
import com.example.devhive_backend.entity.Order;
import java.util.stream.Collectors;
import static com.example.devhive_backend.mapper.OrderProductMapper.mapToOrderProductDTO;

public class OrderMapper {
    public static Order mapToOrder(OrderDTO orderDTO) {
        Order order = Order.builder()
                .id(orderDTO.getId())
                .user(orderDTO.getUser())
                .totalPrice(orderDTO.getTotalPrice())
                .status(orderDTO.getStatus())
                .build();
        return order;
    }

    public static OrderDTO mapToOrderDTO(Order order) {
        OrderDTO orderDTO = OrderDTO.builder()
                .id(order.getId())
                .user(order.getUser())
                .totalPrice(order.getTotalPrice())
                .status(order.getStatus())
                .orderProducts(order.getOrderProducts().stream().map((orderProduct) -> mapToOrderProductDTO(orderProduct)).collect(Collectors.toList()))
                .build();
        return orderDTO;
    }


}
