package com.example.demo.controller;

import com.example.demo.service.AccountSercive;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/account")
@RestController
@MapperScan("com.example.demo.dao")
public class AccountController {

    @Autowired
    AccountSercive accountSercive;

    @RequestMapping(value = "transfer", method = RequestMethod.GET)
    public void transfer(){
        accountSercive.transfer();
    }
}
