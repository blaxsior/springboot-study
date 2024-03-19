package com.example.demo.employee.service;

import com.example.demo.employee.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(int id);
    Employee save(Employee employee);

    void deleteById(int id);
}
