package com.example.shoppingchatbot.dto;

public record UserCreateRequest(
        String username,
        String password,
        String email
) {}
