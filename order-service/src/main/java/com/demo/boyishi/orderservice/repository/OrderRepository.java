package com.demo.boyishi.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.boyishi.orderservice.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {}
