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
@Table(name = "employees")
public class Employee {
    @Id
    @Column(name = "employee_number")
    private int employeeNumber;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "extension", nullable = false)
    private String extension;

    @Column(name = "email", nullable = false)
    private String email;

    @ManyToOne
    @JoinColumn(name = "office_code")
    private Office office;

    @ManyToOne
    @JoinColumn(name = "reports_to")
    private Employee reportsTo;

    @Column(name = "job_title", nullable = false)
    private String jobTitle;

}