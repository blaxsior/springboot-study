package com.example.demo.employee.service;

//import com.example.demo.employee.dao.EmployeeDAO;
import com.example.demo.employee.entity.Employee;
import com.example.demo.employee.repository.EmployeeRepository;
//import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepo;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public List<Employee> findAll() {
        return this.employeeRepo.findAll();
    }

    @Override
    @NonNull
    public Employee findById(int id) {
        var result = this.employeeRepo.findById(id);
        if(result.isEmpty()) {
            throw new RuntimeException("cannot find employee id = " + id);
        }

        return result.get();
    }
//    @Transactional
    // JpaRepository는 내부적으로 @Transactional을 처리해주므로, 필요 X
    @Override
    public Employee save(Employee employee) {
        return this.employeeRepo.save(employee);
    }

//    @Transactional
    @Override
    public void deleteById(int id) {
        this.employeeRepo.deleteById(id);
    }
}
