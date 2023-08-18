package com.example.testboard.controller;

import com.example.testboard.dto.response.OrderdetailResponseDto;
import com.example.testboard.service.OrderdetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/v1/orderdetail")
@RestController
public class OrderdetailController {
    private final OrderdetailService orderdetailService;

    @GetMapping("/info/{orderNumber}/{productCode}")
    @ResponseStatus(HttpStatus.OK)
    public OrderdetailResponseDto getOrderdetail(
            @PathVariable("orderNumber")
            int orderNumber,
            @PathVariable("productCode")
            String productCode
    ) {

        return orderdetailService.getOrderdetail(orderNumber, productCode);
    }
}
