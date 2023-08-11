package com.example.devhive_backend.service.impl;

import com.example.devhive_backend.dto.OrderProductDTO;
import com.example.devhive_backend.entity.OrderProduct;
import com.example.devhive_backend.repository.OrderProductRepository;
import com.example.devhive_backend.service.OrderProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import static com.example.devhive_backend.mapper.OrderProductMapper.mapToOrderProduct;
import static com.example.devhive_backend.mapper.OrderProductMapper.mapToOrderProductDTO;


@Service
public class OrderProductServiceImpl implements OrderProductService {
    @Autowired
    private OrderProductRepository orderProductRepository;

    @Override
    public List<OrderProductDTO> getAllOrderProducts() {
        List<OrderProduct> orderProducts = orderProductRepository.findAll();
        return orderProducts.stream().map((player) -> mapToOrderProductDTO(player)).collect(Collectors.toList());
    }

    @Override
    public OrderProductDTO getOrderProductById(Long id) {
        OrderProduct orderProduct =  orderProductRepository.findById(id).get();
        return mapToOrderProductDTO(orderProduct);
    }

    @Override
    public OrderProduct createOrderProduct(OrderProductDTO orderProductDTO) {
        OrderProduct orderProduct = mapToOrderProduct(orderProductDTO);
        return orderProductRepository.save(orderProduct);
    }

    @Override
    public void updateOrderProduct(OrderProductDTO orderProductDTO) {
        OrderProduct orderProduct = mapToOrderProduct(orderProductDTO);
        orderProductRepository.save(orderProduct);
    }

    @Override
    public void deleteOrderProduct(Long id) {
        orderProductRepository.deleteById(id);
    }
}
