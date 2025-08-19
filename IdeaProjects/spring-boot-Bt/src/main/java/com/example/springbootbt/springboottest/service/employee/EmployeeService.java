package com.example.springbootbt.springboottest.service.employee;


import com.example.springbootbt.springboottest.model.Employee;
import com.example.springbootbt.springboottest.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> findByName(String name) {
        return employeeRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public List<Employee> findByDepartment(String department) {
        return employeeRepository.findByDepartmentContainingIgnoreCase(department);
    }
}

