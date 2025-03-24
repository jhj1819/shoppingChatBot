package com.example.shoppingchatbot.controller;

import com.example.shoppingchatbot.dto.ProductCreateRequest;
import com.example.shoppingchatbot.entity.Category;
import com.example.shoppingchatbot.entity.Product;
import com.example.shoppingchatbot.repository.CategoryRepository;
import com.example.shoppingchatbot.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@Tag(name = "Product API", description = "상품 등록 및 조회 API")
public class ProductController {

    private final ProductService productService;
    private final CategoryRepository categoryRepository;

    public ProductController(ProductService productService, CategoryRepository categoryRepository) {
        this.productService = productService;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping
    @Operation(summary = "상품 목록 조회 API", description = "등록된 상품 목록을 조회합니다.")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @PostMapping
    @Operation(summary = "상품 등록 API", description = "상품을 신규 등록합니다.")
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