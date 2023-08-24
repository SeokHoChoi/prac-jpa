package com.example.testboard.dto.response;

import com.example.testboard.entity.OrderDetail;
import com.example.testboard.entity.OrderDetailId;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import static com.fasterxml.jackson.databind.PropertyNamingStrategy.SnakeCaseStrategy;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@JsonNaming(value = SnakeCaseStrategy.class)
public class OrderDetailResponseDto {
    private OrderDetailId orderDetailId;
    private OrderResponseDto order;
    private ProductResponseDto product;
    private int quantityOrdered;
    private BigDecimal priceEach;
    private short orderLineNumber;
    public static OrderDetailResponseDto from(OrderDetail orderDetail) {
        OrderDetailResponseDto dto = new OrderDetailResponseDto();
        dto.orderDetailId = orderDetail.getId();
        dto.order = OrderResponseDto.from(orderDetail.getOrder());
        if (orderDetail.getProduct() != null){
            dto.product = ProductResponseDto.from(orderDetail.getProduct());
        }
        dto.quantityOrdered = orderDetail.getQuantityOrdered();
        dto.priceEach = orderDetail.getPriceEach();
        dto.orderLineNumber = orderDetail.getOrderLineNumber();
        return dto;
    }
}
