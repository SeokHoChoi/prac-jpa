package com.example.testboard.dto.response;

import com.example.testboard.entity.Order;
import com.example.testboard.entity.OrderDetail;
import com.example.testboard.entity.OrderDetailId;
import com.example.testboard.entity.Product;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class OrderdetailResponseDto {
    @JsonProperty("order_detailId")
    private OrderDetailId orderDetailId;

    @JsonProperty("order")
    private Order order;

    @JsonProperty("product")
    private Product product;

    @JsonProperty("quantity_ordered")
    private int quantityOrdered;

    @JsonProperty("price_each")
    private BigDecimal priceEach;

    @JsonProperty("order_line_number")
    private short orderLineNumber;
    public OrderdetailResponseDto from(OrderDetail orderDetail) {

        this.orderDetailId = orderDetail.getId();
        this.order = orderDetail.getOrder();
        this.product = orderDetail.getProduct();
        this.quantityOrdered = orderDetail.getQuantityOrdered();
        this.priceEach = orderDetail.getPriceEach();
        this.orderLineNumber = orderDetail.getOrderLineNumber();

        return this;
    }
}
