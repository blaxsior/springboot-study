package com.example.demo.course.dao;

import com.example.demo.course.entity.Course;

import java.util.List;

public interface CourseDao {
    List<Course> findAllByInstructorId(Integer instructorId);

    Course findById(Integer id);

    void update(Course course);

    void deleteById(Integer id);
}
