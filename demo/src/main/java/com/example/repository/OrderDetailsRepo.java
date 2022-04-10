package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.OrderDetails;

public interface OrderDetailsRepo extends JpaRepository<OrderDetails, Integer> {
	
}
