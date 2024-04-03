package com.example.demo.course.dao;

import com.example.demo.course.entity.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseDaoImpl implements CourseDao {
    private EntityManager em;

    @Autowired
    public CourseDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Course> findAllByInstructorId(Integer instructorId) {
        TypedQuery<Course> query = em.createQuery("from Course where instructor.id = :instructorId", Course.class)
                .setParameter("instructorId", instructorId);

        var courses = query.getResultList();
        return courses;
    }

    @Override
    public Course findById(Integer id) {
        return this.em.find(Course.class, id);
    }

    @Override
    @Transactional
    public void update(Course course) {
        this.em.merge(course);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        var course = this.em.find(Course.class, id);
        if(course == null) return;

        this.em.remove(course);
    }
}
