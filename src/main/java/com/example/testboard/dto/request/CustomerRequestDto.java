package com.example.testboard.dto.request;

import com.example.testboard.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequestDto {
    private int customerNumber; // db측에서 자동증가가 아니던데?? 왜이럼?
    private String customerName;
    private String contactLastName;
    private String contactFirstName;
    private String phone;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private int salesRepEmployee;
    private BigDecimal creditLimit;
}
