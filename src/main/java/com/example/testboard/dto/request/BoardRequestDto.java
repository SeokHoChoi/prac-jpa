package com.example.testboard.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardRequestDto {
    // id는 그냥 생성할때는 자동이니 없어도 되고 수정에선 있어야하는데 어떡함?
    private String title;
}
