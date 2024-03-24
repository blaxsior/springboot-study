package com.example.demo.customer;

import com.example.demo.customer.dto.Customer;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @GetMapping("/form")
    public String getCustomerForm(Model model) {
        model.addAttribute("customer", new Customer());

        return "/customer/customer-form";
    }

    @PostMapping("/form")
    public String submitCustomerForm(@Valid @ModelAttribute Customer customer, BindingResult bindingResult) {
        System.out.println(customer);
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().stream().forEach(it -> System.out.println(it.getDefaultMessage()));
            return "/customer/customer-form";
        }

        return "/customer/customer-confirm";
    }
}
