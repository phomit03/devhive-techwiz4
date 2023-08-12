package com.example.devhive_backend.service.impl;

import com.example.devhive_backend.dto.ProductDTO;
import com.example.devhive_backend.entity.Product;
import com.example.devhive_backend.repository.ProductRepository;
import com.example.devhive_backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.devhive_backend.mapper.ProductMapper.mapToProduct;
import static com.example.devhive_backend.mapper.ProductMapper.mapToProductDTO;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductDTO> productDTOList = this.transfer(products);
        return productDTOList;
    }

    private List<ProductDTO> transfer(List<Product> products) {
        List<ProductDTO> productDTOList = new ArrayList<>();
        for (Product product : products) {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setId(product.getId());
            productDTO.setName(product.getName());
            productDTO.setImage(product.getImage());
            productDTO.setQuantity(product.getQuantity());
            productDTO.setPrice(product.getPrice());
            productDTO.setCategory(product.getCategory());
            productDTO.setStatus(product.getStatus());
            productDTOList.add(productDTO);
        }
        return productDTOList;
    }

    @Override
    public ProductDTO getProductById(Long id) {
        Product product =  productRepository.findById(id).get();
        return mapToProductDTO(product);
    }

    @Override
    public Product createProduct(ProductDTO productDTO) {
        Product product = mapToProduct(productDTO);
        return productRepository.save(product);
    }



    @Override
    public void updateProduct(ProductDTO productDTO) {
        Product product = mapToProduct(productDTO);
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}

