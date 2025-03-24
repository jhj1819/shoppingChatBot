package com.example.shoppingchatbot.controller;

import com.example.shoppingchatbot.dto.ProductCreateRequest;
import com.example.shoppingchatbot.entity.Category;
import com.example.shoppingchatbot.entity.Product;
import com.example.shoppingchatbot.repository.CategoryRepository;
import com.example.shoppingchatbot.repository.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        productRepository.deleteAll();
        categoryRepository.deleteAll();
    }

    @Test
    void 상품_등록_API() throws Exception {
        Category category = categoryRepository.save(new Category("전자기기", "전자제품"));

        ProductCreateRequest request = new ProductCreateRequest(
                "스마트폰",
                "최신형 스마트폰",
                1200000,
                5,
                category.getId()
        );

        mockMvc.perform(post("/api/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("스마트폰"));
    }

    @Test
    void 상품_조회_API() throws Exception {
        Category category = categoryRepository.save(new Category("가전", "가전 카테고리"));

        // 직접 DB에 상품 insert (Service, Controller 경유 X)
        productRepository.save(new Product("세탁기", "드럼 세탁기", 800000, 8, category));

        mockMvc.perform(get("/api/products"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("세탁기"));
    }
}
