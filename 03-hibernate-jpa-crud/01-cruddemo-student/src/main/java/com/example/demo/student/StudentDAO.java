package com.example.demo.student;

import java.util.List;

public interface StudentDAO {
    void save(Student s);
    Student findById(Integer Id);

    List<Student> findAll();
    List<Student> findByLastName(String lastName);

    void update(Student student);

    void deleteById1(Integer id);
    void deleteById2(Integer id);

    int deleteAll();
}