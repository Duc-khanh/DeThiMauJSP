package com.example.springbootbt.springboottest.service.Order;



import com.example.springbootbt.springboottest.model.Order;

import java.util.List;

public interface IOrderService extends com.example.springbootbt.springboottest.service.Order.IGeneralService<Order> {
    List<Order> findByCustomerName(String customerName);
    List<Order> findByStatus(String status);
}

