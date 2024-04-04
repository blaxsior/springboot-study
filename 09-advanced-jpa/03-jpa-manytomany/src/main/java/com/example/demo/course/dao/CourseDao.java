package com.example.demo.course.dao;

import com.example.demo.course.entity.Course;

import java.util.List;

public interface CourseDao {
    List<Course> findAllByInstructorId(Integer instructorId);

    void save(Course course);
    Course findById(Integer id);

    void update(Course course);

    void deleteById(Integer id);

    Course findWithReviewsById(Integer id);

    Course findWithStudentsById(Integer id);
}
