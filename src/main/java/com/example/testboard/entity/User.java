package com.example.testboard.entity;

import com.example.testboard.dto.request.UserRequestDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID id;

    private LocalDateTime createdAt;

    @NotNull
    @Column(length = 10)
    private String username;

    @NotNull
    private String password;

    // 여따가도 service 간편하게 하기위해 from 만들었는데 괜찮음?
    // 그리고 id는 내가  @GeneratedValue 해놨으니 new 해서 생성할때
    // 자동으로 값 들어가는거 맞음??
    // 아니면 jpa 날릴때  @GeneratedValue 덕분에 자동 생성되는거임?
    // id를 from 에서 안넣어줬는데 어디서 넣는지 헷갈림.
    public User from(UserRequestDto dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setCreatedAt(LocalDateTime.now());
        return user;
    }
}
