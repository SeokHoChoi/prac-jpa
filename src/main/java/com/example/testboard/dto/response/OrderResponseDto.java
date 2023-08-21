package com.example.testboard.dto.response;

import com.example.testboard.entity.Customer;
import com.example.testboard.entity.Order;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderResponseDto {
    private int orderNumber;
    private LocalDate orderDate;
    private LocalDate requiredDate;
    private LocalDate shippedDate;
    private String status;
    private String comments;
    private CustomerResponseDto customer;
    public static OrderResponseDto from(Order order){
        OrderResponseDto dto = new OrderResponseDto();
        dto.setOrderNumber(order.getOrderNumber());
        dto.setOrderDate(order.getOrderDate());
        dto.setRequiredDate(order.getRequiredDate());
        dto.setShippedDate(order.getShippedDate());
        dto.setStatus(order.getStatus());
        dto.setComments(order.getComments());
        if(order.getCustomer() != null){
            dto.setCustomer(CustomerResponseDto.from(order.getCustomer()));
        }
        return dto;
    }
}
