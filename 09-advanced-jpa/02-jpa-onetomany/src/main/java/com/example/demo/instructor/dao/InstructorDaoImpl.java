package com.example.demo.instructor.dao;

import com.example.demo.instructor.entity.Instructor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

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
    public Instructor findById(Integer id) {
        return this.em.find(Instructor.class, id);
    }

    @Override
    public Instructor findWithCoursesById(Integer id) {
        TypedQuery<Instructor> query = this.em.createQuery(
                "select i from Instructor i " +
                        "left join fetch i.courses " +
                        "left join fetch i.instructorDetail " +
                        "where i.id = :id", Instructor.class)
                .setParameter("id", id);

        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        var instructor = this.em.find(Instructor.class, id);
        if(instructor != null) {
            this.em.remove(instructor);
        }
    }

    @Override
    public void update(Instructor instructor) {
        this.em.merge(instructor);
    }

    @Override
    @Transactional
    public void removeById(Integer id) {
        var instructor = this.findWithCoursesById(id);
        if(instructor == null) return;

        var courses = instructor.getCourses();

        for(var course: courses) {
            course.setInstructor(null);
        }

        this.em.remove(instructor);
    }
}
