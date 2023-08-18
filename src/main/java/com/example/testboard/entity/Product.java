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
    @Column(name = "product_code")
    private String productCode;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @ManyToOne
    @JoinColumn(name = "product_line")
    private ProductLine productLine;

    @Column(name = "product_scale", nullable = false)
    private String productScale;

    @Column(name = "product_vendor", nullable = false)
    private String productVendor;

    @Column(name = "product_description", nullable = false, columnDefinition = "text")
    private String productDescription;

    @Column(name = "quantity_in_stock",columnDefinition = "SMALLINT", nullable = false)
    private int quantityInStock;

    @Column(name = "buy_price", nullable = false)
    private BigDecimal buyPrice;

    @Column(name = "m_s_r_p", nullable = false)
    private BigDecimal MSRP;
}