package com.example.testboard.controller;

import com.example.testboard.dto.request.UserRequestDto;
import com.example.testboard.dto.response.UserResponseDto;
import com.example.testboard.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDto signup(@RequestBody UserRequestDto dto) {
        return userService.signup(dto);
    }

    // 나중에 TokenDto 만들어서 반환해야함. 근데 일단 어려움.
    // 그러니 id 받으면 그거로 로그인된거라고 생각하도록 하자.
    // 시큐리티는 더 어려운데 뭐든 복붙하면 성공해버림.
    @PostMapping("/login")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDto login(@RequestBody UserRequestDto dto) {
        return userService.login(dto);
    }

    // 로그아웃을 할때 회원의 pk인 ID를 url로 노출시키면 위험할거 같아서 post했는데 맞을까?
    @PostMapping("/logout")
    public void logout() {}

    @PutMapping("/update")
    public void update() {}

    @GetMapping("/get-info")
    public void getInfo() {}

    @DeleteMapping("/withdrawal")
    public void withdrawal() {}
}
