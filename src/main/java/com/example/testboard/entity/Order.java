package com.example.testboard.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @Column(name = "order_number")
    private int orderNumber;

    @Column(name = "order_date", nullable = false)
    private Date orderDate;

    @Column(name = "required_date", nullable = false)
    private Date requiredDate;

    @Column(name = "shipped_date")
    private Date shippedDate;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "comments", columnDefinition = "text")
    private String comments;

    @ManyToOne
    @JoinColumn(name = "customer_number")
    private Customer customer;
}