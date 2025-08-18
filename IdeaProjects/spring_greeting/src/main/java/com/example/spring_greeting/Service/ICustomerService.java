package com.example.spring_greeting.Service;

import com.example.spring_greeting.Model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    Customer findById(int id);
}
