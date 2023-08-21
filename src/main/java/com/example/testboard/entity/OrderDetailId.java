package com.example.testboard.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class OrderDetailId implements Serializable {

    @Column(name = "order_number")
    private int orderNumber;

    @Column(name = "product_code", length = 15)
    private String productCode;

    public static OrderDetailId from(int orderNumber, String productCode) {
        OrderDetailId id = new OrderDetailId();
        id.orderNumber = orderNumber;
        id.productCode = productCode;
        return id;
    }
}