package com.example.demo.instructor.dao;

import com.example.demo.instructor.entity.Instructor;

public interface InstructorDao {
    void save(Instructor instructor);

    Instructor findInstructorById(Integer id);

    void deleteInstructorById(Integer id);
}
