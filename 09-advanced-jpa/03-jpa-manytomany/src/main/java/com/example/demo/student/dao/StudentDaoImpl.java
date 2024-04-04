package com.example.demo.student.dao;

import com.example.demo.student.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class StudentDaoImpl implements StudentDao{
    private EntityManager em;

    @Autowired
    public StudentDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Optional<Student> findWithCoursesById(Integer id) {
        TypedQuery<Student> query = this.em.createQuery(
                "select s from Student s " +
                        "left join fetch s.courses " +
                        "where s.id=:id", Student.class
        ).setParameter("id", id).setMaxResults(1);

        return query.getResultList().stream().findFirst();
    }

    @Override
    public Optional<Student> findById(Integer id) {
        var student = this.em.find(Student.class, id);
        return Optional.ofNullable(student);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        var student = this.em.find(Student.class, id);

        if(student != null) {
            this.em.remove(student);
        }
    }

    @Override
    @Transactional
    public void deleteByIdWithJPQLQuery(Integer id) {
        this.em.createQuery("delete from Student where id=:id")
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    @Transactional
    public void update(Student student) {
        this.em.merge(student);
    }
}
