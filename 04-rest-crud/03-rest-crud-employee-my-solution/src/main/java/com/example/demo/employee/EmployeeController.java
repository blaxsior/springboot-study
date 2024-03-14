package com.example.demo.employee;

import com.example.demo.employee.dto.CreateEmployeeDTO;
import com.example.demo.employee.dto.ModifyEmployeeDTO;
import com.example.demo.employee.entity.Employee;
import com.example.demo.employee.repository.EmployeeDAO;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeController(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @GetMapping
    public List<Employee> getEmployees() {
        return this.employeeDAO.findAll();
    }

    @GetMapping("/{empId}")
    public Employee getEmployee(@PathVariable Integer empId) {
        return this.employeeDAO.findById(empId);
    }

    @PostMapping
    public void createEmployee(@Valid @RequestBody CreateEmployeeDTO dto) {
        var new_employee = new Employee.Builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .email(dto.getEmail())
                .build();
        this.employeeDAO.save(new_employee);
    }

    // PUT은 모든 값을 뒤집어 쓴다.
    @PutMapping
    @Transactional
    public void updateEmployee(@Valid @RequestBody ModifyEmployeeDTO dto) {
        var employee = this.employeeDAO.findById(dto.getId());
        if(employee == null) { return; }

        this.employeeDAO.update(employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable int id) {
        this.employeeDAO.deleteById(id);
    }

//    @ExceptionHandler({Exception.class})
//    public ResponseEntity<String> handleException(Exception e) {
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error");
//    }
}
