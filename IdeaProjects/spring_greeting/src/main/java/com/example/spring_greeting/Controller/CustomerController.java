package com.example.spring_greeting.Controller.Controller;


import com.example.spring_greeting.Controller.Model.Customer;
import com.example.spring_greeting.Controller.Service.CustomerService;
import com.example.spring_greeting.Controller.Service.SimpleCustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class CustomerController {


    @Autowired
    private SimpleCustomerServiceImpl customerService;

    @GetMapping("/customers")
    public String showList(Model model) {
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customers", customers);
        return "customers/list";
    }
    @GetMapping("/customer/{id}")
    public String showDetail(@PathVariable("id") int id, Model model) {
        Customer customer = customerService.findById(id);
        model.addAttribute("customer", customer);
        return "customers/info";
    }
}
