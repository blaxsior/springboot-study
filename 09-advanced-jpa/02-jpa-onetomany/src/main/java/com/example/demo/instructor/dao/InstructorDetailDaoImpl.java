package com.example.demo.instructor.dao;

import com.example.demo.instructor.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class InstructorDetailDaoImpl implements InstructorDetailDao {
    private EntityManager em;

    @Autowired
    public InstructorDetailDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public InstructorDetail findById(Integer id) {
        return this.em.find(InstructorDetail.class, id);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) { // instructor은 남기면서 삭제
        var instructorDetail = this.em.find(InstructorDetail.class, id);
        if(instructorDetail != null) {
            // DB on update 옵션은 SQL 수준에서 작성해서 설정해주면 됨
            // cascade != on update / on delete임을 명심!
            instructorDetail.getInstructor().setInstructorDetail(null); // 연관 관계 삭제
            this.em.remove(instructorDetail);
        }
    }
}
