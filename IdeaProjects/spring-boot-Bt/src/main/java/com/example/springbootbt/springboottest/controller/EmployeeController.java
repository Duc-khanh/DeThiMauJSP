package com.example.springbootbt.springboottest.controller;


import com.example.springbootbt.springboottest.model.Employee;
import com.example.springbootbt.springboottest.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        return employeeService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        return employeeService.findById(id)
                .map(existing -> {
                    employee.setEmployeeId(id);
                    return ResponseEntity.ok(employeeService.save(employee));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        if (employeeService.findById(id).isPresent()) {
            employeeService.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/search/name")
    public List<Employee> searchByName(@RequestParam String name) {
        return employeeService.findByName(name);
    }

    @GetMapping("/search/department")
    public List<Employee> searchByDepartment(@RequestParam String department) {
        return employeeService.findByDepartment(department);
    }
}

