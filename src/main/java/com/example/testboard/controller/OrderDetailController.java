package com.example.testboard.controller;

import com.example.testboard.dto.response.OrderDetailResponseDto;
import com.example.testboard.service.OrderDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/v1/orderdetail")
@RestController
public class OrderDetailController {
    private final OrderDetailService orderDetailService;

    @GetMapping("/info/{orderNumber}/{productCode}")
    @ResponseStatus(HttpStatus.OK)
    public OrderDetailResponseDto getOrderdetail(
            @PathVariable("orderNumber")
            int orderNumber,
            @PathVariable("productCode")
            String productCode
    ) {

        return orderDetailService.getOrderdetail(orderNumber, productCode);
    }
}
