package com.example.demo.rest;

import com.example.demo.student.Student;
import com.example.demo.student.exception.StudentErrorResponse;
import com.example.demo.student.exception.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private List<Student> students;

    @PostConstruct
    void loadData() {
        this.students = new ArrayList<>();
        this.students.add(new Student("gildong", "hong"));
        this.students.add(new Student("moss", "brick"));
        this.students.add(new Student("steak", "creator"));
    }

    @GetMapping
    public List<Student> getStudents() {
        // Spring 프레임워크는 Jackson을 이용하여 List<Student>를 적절한 JSON 배열로 변환
        return this.students;
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable("id") int id) {
        // 잘못된 음수 인덱스를 접근
        if(id >= this.students.size() || id < 0) {
            throw new StudentNotFoundException("Student not found, id = " + id);
        }

        return this.students.get(id);
    }
}
