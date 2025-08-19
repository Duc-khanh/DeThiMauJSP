package com.example.springbootbt.springboottest.repository;


import com.example.springbootbt.springboottest.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByCustomerNameContainingIgnoreCase(String customerName);
    List<Order> findByStatus(String status);
}
