package com.example.demo.instructor.dao;

import com.example.demo.instructor.entity.Instructor;

public interface InstructorDao {
    void save(Instructor instructor);

    Instructor findById(Integer id);

    void deleteById(Integer id);
}
