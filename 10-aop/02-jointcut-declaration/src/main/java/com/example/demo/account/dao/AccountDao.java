package com.example.demo.account.dao;

import com.example.demo.account.entity.Account;

import java.util.List;

public interface AccountDao {
    void addAccount(Account account);
    void addAccount2(Account account, boolean vipFlag);

    List<Account> findAccounts();

    String getName();

    public void setName(String name);

    public String getServiceCode();
    public void setServiceCode(String serviceCode);
}
