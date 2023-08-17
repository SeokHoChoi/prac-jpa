package com.example.testboard.dto.response;

import com.example.testboard.dto.request.BoardRequestDto;
import com.example.testboard.entity.Board;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class BoardResponseDto {
    /*
        access = AccessLevel.PRIVATE 를 사용하여 new로 생성을 못함.
        static으로 이용하게 하는거임.

        단일책임원칙에 의해 new로하거나 stattic 생성자로 하거나.
     */
    private UUID id;
    private String title;
    private LocalDateTime createdAt;

    // Board로 부터 생성된 BoardResponseDto
    public static BoardResponseDto from(Board board) {
        BoardResponseDto result = new BoardResponseDto();
        result.setId(board.getId());
        result.setTitle(board.getTitle());
        result.setCreatedAt(board.getCreatedAt());
        return result;
    }

    // of: ~의
    public static BoardResponseDto of(UUID id){
        BoardResponseDto result = new BoardResponseDto();
        result.setId(id);
        return result;
    }

    public static BoardResponseDto of(UUID id , String title){
        BoardResponseDto result = of(id);
        result.setTitle(title);
        return result;
    }
    public static BoardResponseDto of(UUID id, String title, LocalDateTime createdAt){
        BoardResponseDto result = of(id,title);
        result.setCreatedAt(createdAt);
        return result;
    }
}
