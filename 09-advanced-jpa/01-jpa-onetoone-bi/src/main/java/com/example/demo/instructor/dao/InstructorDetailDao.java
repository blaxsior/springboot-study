package com.example.demo.instructor.dao;

import com.example.demo.instructor.entity.InstructorDetail;

public interface InstructorDetailDao {
    InstructorDetail findById(Integer id);

    void deleteById(Integer id);
}
