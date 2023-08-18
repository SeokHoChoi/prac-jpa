package com.example.testboard.service;

import com.example.testboard.dto.response.OrderdetailResponseDto;
import com.example.testboard.entity.OrderDetail;
import com.example.testboard.entity.OrderDetailId;
import com.example.testboard.exception.NotFoundException;
import com.example.testboard.repository.OrderdetailRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Transactional
@Service
public class OrderdetailService {
    private final OrderdetailRepository orderdetailRepository;

    public OrderdetailResponseDto getOrderdetail(int orderNumber, String productCode) {
        OrderDetailId orderdetailId = new OrderDetailId(orderNumber, productCode);
        OrderDetail orderDetail = orderdetailRepository.findById(orderdetailId).orElseThrow(NotFoundException::new);
        OrderdetailResponseDto resDto = new OrderdetailResponseDto();

        return resDto.from(orderDetail);
    }
}
