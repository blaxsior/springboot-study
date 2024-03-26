package com.example.demo.employee.service;

import com.example.demo.employee.EmployeeRepository;
import com.example.demo.employee.dto.EmployeeCreateDTO;
import com.example.demo.employee.dto.EmployeeUpdateDTO;
import com.example.demo.employee.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    @Transactional
    public void create(EmployeeCreateDTO dto) {
        var employee = Employee.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .email(dto.getEmail())
                .build();

        this.employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public void update(EmployeeUpdateDTO dto) {
        var employee = Employee.builder()
                .id(dto.getId())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .email(dto.getEmail())
                .build();

        this.employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        this.employeeRepository.deleteById(id);
    }

    @Override
    public Optional<Employee> getEmployeeById(Integer id) {
        return this.employeeRepository.findById(id);
    }

    @Override
    public List<Employee> getEmployees() {
        return this.employeeRepository.findAll();
    }
}
