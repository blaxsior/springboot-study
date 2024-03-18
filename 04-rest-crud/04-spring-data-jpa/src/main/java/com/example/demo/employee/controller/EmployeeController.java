package com.example.demo.employee.controller;

import com.example.demo.employee.dao.EmployeeDAO;
import com.example.demo.employee.entity.Employee;
import com.example.demo.employee.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> findAll() {
        return employeeService.findAll();
    }
    //  /employees/{id}에 매핑. path variable을 사용
    @GetMapping("/{id}")
    public Employee findById(@PathVariable("id") int id) {
        var employee =  this.employeeService.findById(id);
        // 대상 사원이 없으면 exception 발생
        if(employee == null) throw new RuntimeException("Cannot find Employee id = " + id);
        return employee;
    }

    // 현재 강의에서는 단순한 설명을 위해 DTO 대신 Entity를 직접 사용한다.
    // 나는 spring-boot-starter-validation 패키지를 추가해서 validation까지 처리했음.
    // 우선 강의를 따라가보기 위해 Entity를 사용
    @PostMapping
    public Employee create(@RequestBody Employee empDto) {
        // id 값은 의도적으로 0으로 설정, create 메서드로 업데이트 불가능하게 설정
        // entityManager.merge는 id = 0일 때 값이 없다고 판단
        empDto.setId(0);

        Employee employee = this.employeeService.save(empDto);
        return employee;
    }

    @PutMapping("/{id}")
    public Employee update(@PathVariable int id, @RequestBody Employee empDto) {
        if(id != empDto.getId()) {
            var errorMessage = String.format("Employee not match. expected id = %d, but input is %d", id, empDto.getId());
            throw new RuntimeException(errorMessage);
        }
        System.out.println("this is put");
        return this.employeeService.save(empDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        this.employeeService.deleteById(id);
    }
}
