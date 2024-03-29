package com.example.demo.student;

import com.example.demo.student.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Value("${app.countries}")
    List<String> countries;

    @Value("${app.languages}")
    List<String> languages;

    @Value("${app.favoriteSystems}")
    List<String> favoriteSystems;

    @GetMapping("/form")
    public String studentForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);

        model.addAttribute("countries", countries);
        model.addAttribute("languages", languages);
        model.addAttribute("systems", favoriteSystems);

        return "student/student-form";
    }


    @PostMapping("/processStudentForm")
    public String processStudent(@ModelAttribute("student") Student student) {
        System.out.println(student);
        return "student/student-confirmation";
    }
}
