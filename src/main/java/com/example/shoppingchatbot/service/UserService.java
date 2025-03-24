package com.example.shoppingchatbot.service;

import com.example.shoppingchatbot.dto.UserCreateRequest;
import com.example.shoppingchatbot.entity.User;
import com.example.shoppingchatbot.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(UserCreateRequest request) {
        // 비밀번호 암호화는 추후 추가
        User user = new User(request.username(), request.password(), request.email());
        return userRepository.save(user);
    }
}
