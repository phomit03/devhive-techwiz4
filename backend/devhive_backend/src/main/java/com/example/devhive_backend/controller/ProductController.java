package com.example.devhive_backend.controller;

import com.example.devhive_backend.dto.ProductDTO;
import com.example.devhive_backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("getAll")
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        List<ProductDTO> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
        ProductDTO productById = productService.getProductById(id);
        return new ResponseEntity<>(productById,HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createProduct(@ModelAttribute ProductDTO productDTO, @RequestParam("imageFile") MultipartFile imageFile) {
        productService.createProduct(productDTO, imageFile);
        return new ResponseEntity<>("Product created successfully",HttpStatus.OK);
    }
    @PostMapping("/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable("id") Long id, @RequestBody ProductDTO productDTO, @RequestParam("image") MultipartFile image) {
        productDTO.setId(id);
        productService.updateProduct(productDTO, image);
        return new ResponseEntity<>("Product updated successfully",HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>("Product delete successfully",HttpStatus.OK);
    }
}
