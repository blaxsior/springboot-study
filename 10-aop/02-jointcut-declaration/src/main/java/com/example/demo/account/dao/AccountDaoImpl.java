package com.example.demo.account.dao;

import com.example.demo.account.entity.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDaoImpl implements AccountDao {
    // 단순 학습 용도 코드!
    private String name;
    private String serviceCode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    @Override
    public void addAccount(Account account) {
        System.out.println(this.getClass() + " DOING DB WORK, ADDING ACCOUNT");
    }

    @Override
    public void addAccount2(Account account, boolean vipFlag) {
        System.out.println(this.getClass() + " DOING DB WORK, ADDING ACCOUNT, vipFlag = " + vipFlag);
    }

    @Override
    public List<Account> findAccounts() {
        List<Account> myAccounts = new ArrayList<>();

        // sample Accounts

        return myAccounts;
    }
}
