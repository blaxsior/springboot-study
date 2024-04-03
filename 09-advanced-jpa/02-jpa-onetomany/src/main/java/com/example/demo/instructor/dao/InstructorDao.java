package com.example.demo.instructor.dao;

import com.example.demo.instructor.entity.Instructor;

public interface InstructorDao {
    void save(Instructor instructor);

    Instructor findById(Integer id);

    Instructor findWithCoursesById(Integer Id);

    void deleteById(Integer id);

    void update(Instructor instructor);

    void removeById(Integer id);
}
