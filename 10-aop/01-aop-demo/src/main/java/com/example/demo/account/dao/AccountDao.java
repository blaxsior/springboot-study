package com.example.demo.account.dao;

import com.example.demo.account.entity.Account;

public interface AccountDao {
    void addAccount(Account account);
    void addAccount2(Account account, boolean vipFlag);
}
