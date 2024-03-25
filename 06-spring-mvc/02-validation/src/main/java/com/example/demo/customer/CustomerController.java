package com.example.demo.customer;

import com.example.demo.customer.dto.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyEditor;

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
            bindingResult.getAllErrors().stream().forEach(it -> System.out.println(it));
            return "/customer/customer-form";
        }

        return "/customer/customer-confirm";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // 전처리를 위한 에디터를 binder에 추가, 공백 문자만 있는 경우를 제외 가능
        StringTrimmerEditor trimmerEditor = new StringTrimmerEditor(true);
        binder.registerCustomEditor(String.class, trimmerEditor);
    }
}
