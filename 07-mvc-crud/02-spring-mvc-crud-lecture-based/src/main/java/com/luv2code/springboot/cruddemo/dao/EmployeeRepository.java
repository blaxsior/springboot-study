package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // 쿼리와 정의에 의한 결과는 동일
    @Query("select emp from Employee emp order by emp.lastName asc")
    public List<Employee> findAllByOrderByLastNameAsc();
}
