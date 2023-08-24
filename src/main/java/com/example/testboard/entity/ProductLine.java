package com.example.testboard.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product_lines")
public class ProductLine {
    @Id
    private String productLine;
    private String textDescription;
    @Column(columnDefinition = "mediumtext")
    private String htmlDescription;
    @Column(columnDefinition = "mediumblob")
    private byte[] image;
}