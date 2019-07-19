package com.example.demo.service;

import com.example.demo.dao.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountSercive {

    @Autowired
    AccountMapper accountMapper;

    @Transactional
    public void transfer() throws RuntimeException{
        accountMapper.update(100,1);//用户1减10块 用户2加10块
        int i=1/0;
        accountMapper.update(110,2);
    }
}
