package com.example.testboard.dto.response;

import com.example.testboard.entity.Customer;
import com.example.testboard.entity.Employee;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CustomerResponseDto {
    // 모든 필드를 다 만든 이유는 응답해줄때 관련정보를 전부 넘겨주기 위해서임.
    // Entity랑 구조가 똑같이함. 이게 맞음?
    // requestDto랑은 pk인 customerNumber 유무뿐이 없음..
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
    private EmployeeResponseDto salesRepEmployee;
    private BigDecimal creditLimit;

    public static CustomerResponseDto from (Customer customer) {
        CustomerResponseDto customerResponseDto = new CustomerResponseDto();
        customerResponseDto.setCustomerNumber(customer.getCustomerNumber());
        customerResponseDto.setCustomerName(customer.getCustomerName());
        customerResponseDto.setContactLastName(customer.getContactLastName());
        customerResponseDto.setContactFirstName(customer.getContactFirstName());
        customerResponseDto.setPhone(customer.getPhone());
        customerResponseDto.setAddressLine1(customer.getAddressLine1());
        customerResponseDto.setAddressLine2(customer.getAddressLine2());
        customerResponseDto.setCity(customer.getCity());
        customerResponseDto.setState(customer.getState());
        customerResponseDto.setPostalCode(customer.getPostalCode());
        customerResponseDto.setCountry(customer.getCountry());
        if(customer.getSalesRepEmployee()!=null) {
            customerResponseDto.setSalesRepEmployee(EmployeeResponseDto.from(customer.getSalesRepEmployee()));
        }
        customerResponseDto.setCreditLimit(customer.getCreditLimit());
        return customerResponseDto;
    }

}
