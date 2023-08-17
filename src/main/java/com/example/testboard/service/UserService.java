package com.example.testboard.service;

import com.example.testboard.dto.request.UserRequestDto;
import com.example.testboard.dto.response.UserResponseDto;
import com.example.testboard.entity.User;
import com.example.testboard.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    public UserResponseDto signup(UserRequestDto dto) {
        User user = new User();
        UserResponseDto responseDto = new UserResponseDto();

        return responseDto.from(userRepository.save(user.from(dto)));
    }

    public UserResponseDto login(UserRequestDto dto) {
        UserResponseDto responseDto = new UserResponseDto();
        return responseDto.from(userRepository
                .findByUsernameAndPassword(
                        dto.getUsername(),
                        dto.getPassword()
                ).get());
    }
}
