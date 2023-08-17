package com.example.testboard.service;

import com.example.testboard.dto.request.BoardRequestDto;
import com.example.testboard.dto.response.BoardResponseDto;
import com.example.testboard.entity.Board;
import com.example.testboard.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository repository;

    public List<BoardResponseDto> getBoard() {

        return repository.findAll().stream().map(BoardResponseDto::from).toList();

        // 위의 코드에서 null 때문에 에러가나서 리팩토링함
//        if (repository.findAll().isEmpty()) {
//            return Collections.emptyList();
//        }
//
//        return repository.findAll().stream().map(b -> {
//            BoardResponseDto dto = new BoardResponseDto();
//            dto.setId(b.getId());
//            dto.setTitle(b.getTitle());
//            dto.setCreatedAt(b.getCreatedAt());
//            return dto;
//        }).toList();

    }

    public BoardResponseDto getOne(UUID id) {
        Board board = repository.findById(id).orElseThrow(RuntimeException::new);
        return BoardResponseDto.from(board);
    }

    /*
    위에 애들 요케 줄일수있음
       public BoardResponseDto getOne(UUID id) {
        return repository.findById(id).map(BoardResponseDto::from).orElseThrow(RuntimeException::new);
    }
     */

    public BoardResponseDto createBoard(BoardRequestDto request) {
        Board board = new Board();
        //시간 이상하게 저장되는데 백엔드 자체에서 좀 제대로 저장하는법없음?
        board.setTitle(request.getTitle());
        board.setCreatedAt(LocalDateTime.now());
        // 얘를 어떡해야함? 반환은 boardResponseDto 이건데
        // 리포지터리 제네릭 타입이 Board임
        // 게다가 id 자동생성은 Board 에다가만 해둬서 나머진 생성인안돼서 코드이렇게짬..
        // 반환은?
        // 이러면 이상함
//        return repository.save(board);
        return BoardResponseDto.from(repository.save(board));
    }

    public void delete(UUID id) {
         repository.deleteById(id);
    }

    public void put(UUID id, BoardRequestDto request) {
        Board board = repository.findById(id).orElseThrow(RuntimeException::new);

        // 일단 수정해주고...
        board.setTitle(request.getTitle());
        repository.save(board);
    }
}
