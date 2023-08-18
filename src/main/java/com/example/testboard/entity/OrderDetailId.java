package com.example.testboard.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class OrderDetailId implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "order_number")
    private int orderNumber;

    @Column(name = "product_code", length = 15)
    private String productCode;



//    @ManyToOne(fetch = FetchType.EAGER)
//    @MapsId("order_number")
//    @JoinColumn(name = "order_number")
//    private Order order;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @MapsId("product_code")
//    @JoinColumn(name = "product_code")
//    private Product product;
}