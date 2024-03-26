package com.luv2code.springboot.cruddemo.controller;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model model) {
        // 데이터베이스에서 모델 가져오기
        var employees = employeeService.findAll();
        model.addAttribute("employees", employees);
        // view 반환
        return "employees/list-employees";
    }

    @GetMapping("/addForm")
    public String addForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employees/add-employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(
            @ModelAttribute("employee") Employee employee,
            BindingResult result
    ) {
        this.employeeService.save(employee);

        return "redirect:/employees/list";
    }

    @GetMapping("/edit")
    public String editEmployee(
            @RequestParam("employeeId") Integer employeeId,
            Model model
    ) {
        System.out.println(employeeId);
        var employee = this.employeeService.findById(employeeId);

        if(employee == null) {
            return "redirect:/employees/list";
        }

        model.addAttribute("employee", employee);
        return "employees/update-employee-form";
    }

    @GetMapping("/delete")
    public String deleteEmployee(
            @RequestParam("employeeId") Integer employeeId
    ) {
        this.employeeService.deleteById(employeeId);
        return "redirect:/employees/list";
    }
}
