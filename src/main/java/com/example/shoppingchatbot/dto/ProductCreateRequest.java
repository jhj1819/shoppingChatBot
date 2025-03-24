package com.example.shoppingchatbot.dto;

// record: 자동으로 getter, 생성자, toString(), equals(), hashCode()를 만들어 줌
public record ProductCreateRequest(
        String name,
        String description,
        int price,
        int stock,
        Long categoryId
) {}