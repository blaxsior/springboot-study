package com.example.demo.student;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;



import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {
    private EntityManager em;

    @Autowired // Autowired 없어도 됨
    public StudentDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    @Transactional
    public void save(Student s) {
        this.em.persist(s);
    }

    @Override
    @Nullable
    public Student findById(Integer id) {
        // 없으면 null 반환
        return this.em.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        return this.em.createQuery("from Student", Student.class).getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        return this.em.createQuery("from Student where lastName=:lastName", Student.class)
                .setParameter("lastName", lastName)
                .getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        this.em.merge(student);
    }

    @Override
    @Transactional
    public void deleteById1(Integer id) {
        var student = this.em.find(Student.class, id);
        this.em.remove(student);
    }

    @Override
    @Transactional
    public void deleteById2(Integer id) {
        this.em.createQuery("DELETE FROM Student WHERE id=:id").setParameter("id", id).executeUpdate();
    }

    @Override
    @Transactional
    public int deleteAll() {
        return this.em.createQuery("DELETE from Student ").executeUpdate();
    }
}
