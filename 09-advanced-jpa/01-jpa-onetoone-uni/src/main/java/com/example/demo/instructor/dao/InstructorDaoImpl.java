package com.example.demo.instructor.dao;

import com.example.demo.instructor.entity.Instructor;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class InstructorDaoImpl implements InstructorDao {
    private EntityManager em;

    @Autowired
    public InstructorDaoImpl(EntityManager em) {
        this.em = em;
    }
    @Override
    @Transactional
    public void save(Instructor instructor) {
        this.em.persist(instructor);
    }

    @Override
    public Instructor findInstructorById(Integer id) {
        return this.em.find(Instructor.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructorById(Integer id) {
        var instructor = this.em.find(Instructor.class, id);
        if(instructor != null) {
            this.em.remove(instructor);
        }
    }
}
