package com.example.demo.employee.repository;

import com.example.demo.employee.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    void save(Employee employee);

    List<Employee> findAll();
    Employee findById(Integer id);

    void update(Employee employee);

    void deleteById(Integer id);
}
