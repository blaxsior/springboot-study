package com.example.demo.employee.repository;

import com.example.demo.employee.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    private EntityManager em;

    @Autowired
    public EmployeeDAOImpl(EntityManager em) {
        this.em = em;
    }
    @Override
    @Transactional
    public void save(Employee employee) {
        this.em.persist(employee);
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query = this.em.createQuery("from Employee", Employee.class);
        return query.getResultList();
    }

    @Override
    public Employee findById(Integer id) {
        return this.em.find(Employee.class, id);
    }

    @Override
    @Transactional
    public void update(Employee employee) {
        this.em.merge(employee);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        this.em.createQuery("delete from Employee where id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }
}
