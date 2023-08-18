package com.example.testboard.repository;

import com.example.testboard.entity.OrderDetail;
import com.example.testboard.entity.OrderDetailId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderdetailRepository extends JpaRepository<OrderDetail, OrderDetailId> {
}
