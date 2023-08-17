package com.example.testboard.controller;

import com.example.testboard.dto.request.BoardRequestDto;
import com.example.testboard.dto.response.BoardResponseDto;
import com.example.testboard.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RequestMapping("/api/v1/board")
@RestController
public class BoardController {
    // 파이널 안적어서 계속 오류
    private final BoardService boardService;

    @GetMapping("/health-check")
    @ResponseStatus(HttpStatus.OK)
    public void healthCheck() {
    }

    @GetMapping("/test")
    public List<BoardResponseDto> getBoard() {
        return boardService.getBoard();
    }

    @GetMapping("/test/{id}")
    public BoardResponseDto getDetailBoard(@PathVariable UUID id) {
        return boardService.getOne(id);
    }

    @DeleteMapping("/test/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") UUID id) {
        // 되긴 되는데 보통 삭제된 애의 객체를 반환해주던데
        // service에서 select 한번 날려서 찾고 그걸 반화해주면 되는거임?
        // 뭔가 쓸데없는 작업 한번더 하는거같아서 애매함.
         boardService.delete(id);
    }

    // 마찬가지
    @PutMapping("/test/{id}")
    public void put(@PathVariable("id") UUID id, @RequestBody BoardRequestDto request
    ) {
        boardService.put(id, request);
    }


    @PostMapping("/post/test")
    public BoardResponseDto createBoard(
        @RequestBody BoardRequestDto request
    ) {
        // BoardRequestDto 엔 createdAt이 없는데 왜 createdAt을 안넣으면
        // 바디에 받아오질 못하지?? 넣어야 받아옴.
        // ㄴㄴ 아니엿음 텔런드에서 계속 마지막에 습관적으로 , 를 붙여서
        // 에러났던 거였음.
        return boardService.createBoard(request);
    }
}

