package com.example.testboard.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.BigInteger;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
public class Product {
    @Id
    private String productCode;

    @Column(nullable = false)
    private String productName;

    @ManyToOne
    @JoinColumn(name = "product_line")
    private ProductLine productLine;

    @Column(nullable = false)
    private String productScale;

    @Column(nullable = false)
    private String productVendor;

    @Column(columnDefinition = "text", nullable = false)
    private String productDescription;

    @Column(columnDefinition = "SMALLINT", nullable = false)
    private int quantityInStock;

    @Column(nullable = false)
    private BigDecimal buyPrice;

    @Column(nullable = false)
    private BigDecimal m_s_r_p;
}