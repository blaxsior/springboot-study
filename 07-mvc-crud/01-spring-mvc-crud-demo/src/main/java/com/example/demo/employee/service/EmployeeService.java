package com.example.demo.employee.service;

import com.example.demo.employee.dto.EmployeeCreateDTO;
import com.example.demo.employee.dto.EmployeeUpdateDTO;
import com.example.demo.employee.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    public void create(EmployeeCreateDTO employee);

    public void update(EmployeeUpdateDTO employee);

    public void deleteById(Integer id);

    public Optional<Employee> getEmployeeById(Integer id);

    public List<Employee> getEmployees();
}
