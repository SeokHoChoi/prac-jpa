package com.example.testboard.repository;

import com.example.testboard.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface BoardRepository extends JpaRepository<Board, UUID> {
}
