package com.example.springbootbt.springboottest.service.employee;


import com.example.springbootbt.springboottest.model.Employee;

import java.util.List;

public interface IEmployeeService extends IGeneralService<Employee> {
    List<Employee> findByName(String name);
    List<Employee> findByDepartment(String department);
}
