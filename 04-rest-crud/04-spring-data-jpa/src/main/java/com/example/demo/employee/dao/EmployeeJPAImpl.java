package com.example.demo.employee.dao;

import com.example.demo.employee.entity.Employee;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeJPAImpl implements EmployeeDAO {
    private EntityManager em;

    @Autowired
    public EmployeeJPAImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Employee> findAll() {
        return this.em
                .createQuery("from Employee ", Employee.class)
                .getResultList();
    }

    @Override
    public Employee findById(int id) {
        return this.em.find(Employee.class, id);
    }

    @Override
    public Employee save(Employee employee) {
        // id == 0 ~= null이면 새로운 객체를 생성, 아니면 갱신
        return this.em.merge(employee);
    }

    @Override
    public void deleteById1(int id) {
        var employee = this.em.find(Employee.class, id);

        if(employee != null) this.em.remove(employee);
    }

    @Override
    public void deleteById2(int id) {
        this.em.createQuery("delete from Employee where id=:id")
                .setParameter("id", id)
                .executeUpdate();
    }
}
