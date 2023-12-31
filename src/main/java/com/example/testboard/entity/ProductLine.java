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
    @Column(name = "product_line")
    private String productLine;

    @Column(name = "text_description")
    private String textDescription;

    @Column(name = "html_description", columnDefinition = "mediumtext")
    private String htmlDescription;

    @Column(name = "image", columnDefinition = "mediumblob")
    private byte[] image;
}