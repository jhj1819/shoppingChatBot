package com.example.shoppingchatbot.controller;

import com.example.shoppingchatbot.dto.UserCreateRequest;
import com.example.shoppingchatbot.entity.User;
import com.example.shoppingchatbot.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@Tag(name = "User API", description = "회원가입 API")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    @Operation(summary = "회원가입 API", description = "새로운 사용자를 등록합니다.")
    public ResponseEntity<User> register(@RequestBody UserCreateRequest request) {
        User savedUser = userService.registerUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }
}
