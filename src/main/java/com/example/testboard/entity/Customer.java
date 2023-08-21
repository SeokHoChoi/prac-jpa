package com.example.testboard.entity;

import com.example.testboard.dto.request.CustomerRequestDto;
import jakarta.persistence.*;
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
@Table(name = "customers")
public class Customer {
    // get 안돼서 insertable = false, updatable = false 해결방법으로 요놈들 추가했으나안됨.
    //     @Column(name = "customerNumber", insertable = false, updatable = false) 이거 안됐음 yml에 추가해야했음.
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerNumber;
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

    @ManyToOne
    @JoinColumn(name = "sales_rep_employee_number")
    private Employee salesRepEmployee;

    private BigDecimal creditLimit;

    // 여긴 form 같은거 못만드나? 지금처럼 이래도 돼?
    public static Customer from(CustomerRequestDto customerRequestDto, Employee employee) {
        Customer customer = new Customer();
        // RequestDto랑 중복이라 줄뜨는데 이걸 따로빼는게 좋은거임??
        // 지금 customerNumber가 자동으로 생성안돼서 에러나는데 어케해야할까.?
        // ㅁㅊ db자체가 자동증가로 안해놨길래 요청객체에서 직접넣게 하니까 됐음.
        // 근데 이렇게 id를 직접 생성하는 경우도 있나?
        customer.setCustomerNumber(customerRequestDto.getCustomerNumber());
        customer.setCustomerName(customerRequestDto.getCustomerName());
        customer.setContactLastName(customerRequestDto.getContactLastName());
        customer.setContactFirstName(customerRequestDto.getContactFirstName());
        customer.setPhone(customerRequestDto.getPhone());
        customer.setAddressLine1(customerRequestDto.getAddressLine1());
        customer.setAddressLine2(customerRequestDto.getAddressLine2());
        customer.setCity(customerRequestDto.getCity());
        customer.setState(customerRequestDto.getState());
        customer.setPostalCode(customerRequestDto.getPostalCode());
        customer.setCountry(customerRequestDto.getCountry());
        // 얘만 요딴식으로 넣어줘도됨??
        customer.setSalesRepEmployee(employee);
        customer.setCreditLimit(customerRequestDto.getCreditLimit());
        return customer;
    }

    // 음... 업데이트 하다가 static 아닌놈이 필요해짐..
    public Customer compare(CustomerRequestDto customerRequestDto, Employee employee) {
        // RequestDto랑 중복이라 줄뜨는데 이걸 따로빼는게 좋은거임??
        // 지금 customerNumber가 자동으로 생성안돼서 에러나는데 어케해야할까.?
        // ㅁㅊ db자체가 자동증가로 안해놨길래 요청객체에서 직접넣게 하니까 됐음.
        // 근데 이렇게 id를 직접 생성하는 경우도 있나?
        this.setCustomerName(customerRequestDto.getCustomerName());
        this.setContactLastName(customerRequestDto.getContactLastName());
        this.setContactFirstName(customerRequestDto.getContactFirstName());
        this.setPhone(customerRequestDto.getPhone());
        this.setAddressLine1(customerRequestDto.getAddressLine1());
        this.setAddressLine2(customerRequestDto.getAddressLine2());
        this.setCity(customerRequestDto.getCity());
        this.setState(customerRequestDto.getState());
        this.setPostalCode(customerRequestDto.getPostalCode());
        this.setCountry(customerRequestDto.getCountry());
        // 얘만 요딴식으로 넣어줘도됨??
        this.setSalesRepEmployee(employee);
        this.setCreditLimit(customerRequestDto.getCreditLimit());
        return this;
    }
}

