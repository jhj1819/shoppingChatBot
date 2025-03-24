package com.example.shoppingchatbot.controller;

import com.example.shoppingchatbot.dto.ProductCreateRequest;
import com.example.shoppingchatbot.entity.Category;
import com.example.shoppingchatbot.entity.Product;
import com.example.shoppingchatbot.repository.CategoryRepository;
import com.example.shoppingchatbot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;
    private final CategoryRepository categoryRepository;

    public ProductController(ProductService productService, CategoryRepository categoryRepository) {
        this.productService = productService;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody ProductCreateRequest dto) {
        Category category = categoryRepository.findById(dto.categoryId())
                .orElseThrow(() -> new RuntimeException("카테고리를 찾을 수 없습니다."));

        Product product = new Product(
                dto.name(),
                dto.description(),
                dto.price(),
                dto.stock(),
                category
        );

        Product savedProduct = productService.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
    }
}