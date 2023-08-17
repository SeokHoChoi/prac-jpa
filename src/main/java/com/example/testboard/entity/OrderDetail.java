package com.example.testboard.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @Column(name = "quantity_ordered", nullable = false)
    private int quantityOrdered;

    @Column(name = "price_each", nullable = false)
    private Double priceEach;

    @Column(name = "order_line_number", nullable = false)
    private short orderLineNumber;

}