package com.example.Ecommerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Ecommerce.entity.OrderMaster;

@Repository
public interface OrderRepository extends JpaRepository<OrderMaster,Long> {

	Optional<OrderMaster> findByUserIdAndOrderTypeAndOrderStatus(Long userId,String orderType,String status);
}
