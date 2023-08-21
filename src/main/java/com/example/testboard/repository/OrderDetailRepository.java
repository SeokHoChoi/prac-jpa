package com.example.testboard.repository;

import com.example.testboard.entity.OrderDetail;
import com.example.testboard.entity.OrderDetailId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailId> {
}
