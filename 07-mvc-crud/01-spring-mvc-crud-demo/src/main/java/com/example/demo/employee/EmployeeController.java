package com.example.demo.employee;

import com.example.demo.employee.dto.EmployeeCreateDTO;
import com.example.demo.employee.dto.EmployeeUpdateDTO;
import com.example.demo.employee.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/index")
    public String index(Model model) {
        var employees = this.employeeService.getEmployees();
        model.addAttribute("employees", employees);

        return "employee/index";
    }

    @GetMapping("/create")
    public String createEmployeeForm(Model model) {
        model.addAttribute("employee", new EmployeeCreateDTO());
        return "employee/create-form";
    }

    @PostMapping("/create")
    public String createEmployee(@Valid @ModelAttribute("employee") EmployeeCreateDTO dto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().stream().forEach(it -> System.out.println(it.getCodes() + it.getDefaultMessage()));
            return "redirect:/employee/create";
        }
        this.employeeService.create(dto);

        return "redirect:/employee/index";
    }

    @GetMapping("/edit/{id}")
    public String editEmployeeForm(
            Model model,
            @PathVariable("id") Integer id
    ) {
        var _optional_employee = this.employeeService.getEmployeeById(id);
        if(_optional_employee.isEmpty()) {
            // 존재하지 않는 유저를 요청하면 index로 보냄.
            // 나중에 에러 페이지로 변경
            return "employee/index";
        }
        var employee = _optional_employee.get();
        model.addAttribute("employee", employee);

        return "employee/update-form";
    }

    @PostMapping("/edit/{id}")
    public String editEmployee(
            @PathVariable("id") Integer id,
            @Valid @ModelAttribute("employee") EmployeeUpdateDTO dto,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().stream().forEach(it -> System.out.println(it.getCodes() + it.getDefaultMessage()));
            return "redirect:/employee/edit/%d" + id;
        }
        this.employeeService.update(dto);

        return "redirect:/employee/index";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(
            @PathVariable("id") Integer id
    ) {
        this.employeeService.deleteById(id);

        return "redirect:/employee/index";
    }

    @ExceptionHandler
    public String handleException() {
        return "error";
    }
}
