package com.example.testboard.dto.response;

import com.example.testboard.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {
    private UUID id;
    private String username;
    private LocalDateTime createdAt;

    public UserResponseDto from(User user) {
        UserResponseDto result = new UserResponseDto();
        result.setId(user.getId());
        result.setUsername(user.getUsername());
        result.setCreatedAt(user.getCreatedAt());
        return result;
    }
}
