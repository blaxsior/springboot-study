package com.example.demo.account.dao;

import com.example.demo.account.entity.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements AccountDao {

    @Override
    public void addAccount(Account account) {
        System.out.println(this.getClass() + " DOING DB WORK, ADDING ACCOUNT");
    }

    @Override
    public void addAccount2(Account account, boolean vipFlag) {
        System.out.println(this.getClass() + " DOING DB WORK, ADDING ACCOUNT, vipFlag = " + vipFlag);
    }
}
