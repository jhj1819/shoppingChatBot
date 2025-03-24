package com.example.shoppingchatbot.service;

import com.example.shoppingchatbot.dto.ProductCreateRequest;
import com.example.shoppingchatbot.entity.Category;
import com.example.shoppingchatbot.entity.Product;
import com.example.shoppingchatbot.repository.CategoryRepository;
import com.example.shoppingchatbot.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @BeforeEach
    void setUp() {
        productRepository.deleteAll();
        categoryRepository.deleteAll();
    }

    @Test
    void 상품_생성_성공() {
        // given
        Category category = categoryRepository.save(new Category("전자기기", "전자제품"));

        ProductCreateRequest request = new ProductCreateRequest(
                "노트북",
                "고성능 노트북",
                1500000,
                10,
                category.getId()
        );

        Product product = new Product(
                request.name(),
                request.description(),
                request.price(),
                request.stock(),
                category
        );

        // when
        Product savedProduct = productService.createProduct(product);

        // then
        assertThat(savedProduct.getId()).isNotNull();
        assertThat(savedProduct.getName()).isEqualTo("노트북");
    }

    @Test
    void 상품_목록_조회() {
        // given
        Category category = categoryRepository.save(new Category("가전", "가전 카테고리"));
        productService.createProduct(new Product("TV", "OLED TV", 1000000, 20, category));

        // when
        var products = productService.getAllProducts();

        // then
        assertThat(products).hasSize(1);
        assertThat(products.get(0).getName()).isEqualTo("TV");
    }
}
