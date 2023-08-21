package com.example.testboard.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orderdetails")
public class OrderDetail {
    @EmbeddedId
    private OrderDetailId id;

    @ManyToOne
    @MapsId("order_number")
    @JoinColumn(name = "order_number")
    private Order order;

    @ManyToOne
    @MapsId("product_code")
    @JoinColumn(name = "product_code")
    private Product product;

    @Column(nullable = false)
    private int quantityOrdered;

    @Column(nullable = false)
    private BigDecimal priceEach;

    @Column(nullable = false)
    private short orderLineNumber;

}