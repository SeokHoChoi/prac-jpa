package com.example.testboard.service;

import com.example.testboard.dto.response.OrderDetailResponseDto;
import com.example.testboard.entity.OrderDetail;
import com.example.testboard.entity.OrderDetailId;
import com.example.testboard.exception.NotFoundException;
import com.example.testboard.repository.OrderDetailRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Transactional
@Service
public class OrderDetailService {
    private final OrderDetailRepository orderdetailRepository;

    public OrderDetailResponseDto getOrderdetail(int orderNumber, String productCode) {
        OrderDetailId orderdetailId = OrderDetailId.from(orderNumber, productCode);
        OrderDetail orderDetail = orderdetailRepository.findById(orderdetailId).orElseThrow(NotFoundException::new);
        return OrderDetailResponseDto.from(orderDetail);
    }
}
