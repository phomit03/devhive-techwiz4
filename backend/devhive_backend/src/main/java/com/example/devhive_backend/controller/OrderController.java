package com.example.devhive_backend.controller;


import com.example.devhive_backend.dto.OrderDTO;
import com.example.devhive_backend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @GetMapping("getAll")
    public ResponseEntity<List<OrderDTO>> getAllOrders() {
        List<OrderDTO> orders = orderService.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable Long id) {
        OrderDTO orderById = orderService.getOrderById(id);
        return new ResponseEntity<>(orderById,HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<String> createOrder(@RequestBody OrderDTO orderDTO) {
        orderService.createOrder(orderDTO);
        return new ResponseEntity<>("Order created successfully",HttpStatus.OK);
    }
    @PostMapping("/{id}")
    public ResponseEntity<String> updateOrder(@PathVariable("id") Long id, @RequestBody OrderDTO orderDTO) {
        orderDTO.setId(id);
        orderService.updateOrder(orderDTO);
        return new ResponseEntity<>("Order updated successfully",HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable("id") Long id) {
        orderService.deleteOrder(id);
        return new ResponseEntity<>("Order delete successfully",HttpStatus.OK);
    }
}