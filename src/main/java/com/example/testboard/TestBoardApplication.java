package com.example.testboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class TestBoardApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestBoardApplication.class, args);
    }
}
