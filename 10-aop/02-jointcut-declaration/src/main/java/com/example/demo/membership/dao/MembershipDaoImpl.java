package com.example.demo.membership.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDaoImpl implements MembershipDao {

    @Override
    public void addMembership() {
        System.out.println(this.getClass() + " DOING DB WORK, ADDING MEMBERSHIP");
    }

    @Override
    public boolean addSillyFunc() {
        System.out.println(this.getClass() + " addSillyFunc");
        return true;
    }
}
