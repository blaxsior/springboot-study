package com.example.demo.employee.dao;

import com.example.demo.employee.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
    Employee findById(int id);
    Employee save(Employee employee);
    
    void deleteById1(int id);
    void deleteById2(int id);
}
