package com.example.shoppingchatbot.service;

import com.example.shoppingchatbot.dto.UserCreateRequest;
import com.example.shoppingchatbot.entity.User;
import com.example.shoppingchatbot.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        userRepository.deleteAll();
    }

    @Test
    void 회원가입_성공() {
        // given
        UserCreateRequest request = new UserCreateRequest("user1", "pass123", "user1@email.com");

        // when
        User savedUser = userService.registerUser(request);

        // then
        assertThat(savedUser.getId()).isNotNull();
        assertThat(savedUser.getUsername()).isEqualTo("user1");
    }

    @Test
    void 회원가입_후_조회() {
        // given
        UserCreateRequest request = new UserCreateRequest("user2", "pass123", "user2@email.com");
        userService.registerUser(request);

        // when
        Optional<User> foundUser = userRepository.findByUsername("user2");

        // then
        assertThat(foundUser).isPresent();
        assertThat(foundUser.get().getEmail()).isEqualTo("user2@email.com");
    }
}
