package com.example.shoppingchatbot.controller;

import com.example.shoppingchatbot.entity.Product;
import com.example.shoppingchatbot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> listProducts() {
        return productService.getAllProducts();
    }
}
