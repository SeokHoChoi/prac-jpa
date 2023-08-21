package com.example.testboard.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "employees")
public class Employee {
    @Id
    private int employeeNumber;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String extension;

    @Column(nullable = false)
    private String email;

    @ManyToOne
    @JoinColumn(name = "office_code")
    private Office office;

    @ManyToOne
    @JoinColumn(name = "reports_to")
    private Employee reportsTo;

    @Column(nullable = false)
    private String jobTitle;

}