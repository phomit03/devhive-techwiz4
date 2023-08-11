package com.example.devhive_backend.controller;

import com.example.devhive_backend.dto.OrderProductDTO;
import com.example.devhive_backend.service.OrderProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order-product")
public class OrderProductController {
    @Autowired
    private OrderProductService orderProductService;
    @GetMapping("getAll")
    public ResponseEntity<List<OrderProductDTO>> getAllOrderProducts() {
        List<OrderProductDTO> orderProducts = orderProductService.getAllOrderProducts();
        return new ResponseEntity<>(orderProducts, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<OrderProductDTO> getOrderProductById(@PathVariable Long id) {
        OrderProductDTO orderProductById = orderProductService.getOrderProductById(id);
        return new ResponseEntity<>(orderProductById,HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<String> createOrderProduct(@RequestBody OrderProductDTO orderProductDTO) {
        orderProductService.createOrderProduct(orderProductDTO);
        return new ResponseEntity<>("OrderProduct created successfully",HttpStatus.CREATED);
    }
    @PostMapping("/{id}")
    public ResponseEntity<String> updateOrderProduct(@PathVariable("id") Long id, @RequestBody OrderProductDTO orderProductDTO) {
        orderProductDTO.setId(id);
        orderProductService.updateOrderProduct(orderProductDTO);
        return new ResponseEntity<>("OrderProduct updated successfully",HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrderProduct(@PathVariable("id") Long id) {
        orderProductService.deleteOrderProduct(id);
        return new ResponseEntity<>("OrderProduct delete successfully",HttpStatus.OK);
    }

}