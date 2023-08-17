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
@Table(name = "payments")
public class Payment {
    @Id
    @ManyToOne
    @JoinColumn(name = "customer_number")
    private Customer customer;

    @Id
    @Column(name = "check_number")
    private String checkNumber;

    @Column(name = "payment_date", nullable = false)
    private Date paymentDate;

    @Column(name = "amount", nullable = false)
    private Double amount;
}