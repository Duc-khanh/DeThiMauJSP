package com.example.springbootbt.springboottest.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    private String name;

    private LocalDate dob;

    private String position;

    private String department;

    private double salary;

    @Column(unique = true)
    private String email;

    private String phone;

    public Employee() {
    }

    public Employee(String name, LocalDate dob, String position, String department, double salary, String email, String phone) {
        this.name = name;
        this.dob = dob;
        this.position = position;
        this.department = department;
        this.salary = salary;
        this.email = email;
        this.phone = phone;
    }

    public Employee(Long employeeId, String name, LocalDate dob, String position, String department, double salary, String email, String phone) {
        this.employeeId = employeeId;
        this.name = name;
        this.dob = dob;
        this.position = position;
        this.department = department;
        this.salary = salary;
        this.email = email;
        this.phone = phone;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}