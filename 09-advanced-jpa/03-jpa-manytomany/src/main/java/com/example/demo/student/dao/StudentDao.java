package com.example.demo.student.dao;

import com.example.demo.student.entity.Student;

import java.util.Optional;

public interface StudentDao {
    Optional<Student> findWithCoursesById(Integer id);

    Optional<Student> findById(Integer id);

    void deleteById(Integer id);

    void deleteByIdWithJPQLQuery(Integer id);

    void update(Student student);
}
