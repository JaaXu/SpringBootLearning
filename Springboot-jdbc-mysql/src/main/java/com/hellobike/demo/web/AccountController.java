package com.hellobike.demo.web;

import com.hellobike.demo.entity.Account;
import com.hellobike.demo.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    IAccountService accountServiceImpl;

    @RequestMapping(value="/{id}",method=RequestMethod.GET)
    public Account getAccountById(@PathVariable("id") int id){
        return accountServiceImpl.findAccountById(id);
    }

    @RequestMapping(value="/delete",method = RequestMethod.GET)
    public String  deleteAccount(int id){
        accountServiceImpl.delete(id);
        return "ok";
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public  String updateAccount(@PathVariable("id")int id , @RequestParam(value = "name",required = true)String name,
                                 @RequestParam(value = "money" ,required = true)double money){
        Account account=new Account();
        account.setMoney(money);
        account.setName(name);
        account.setId(id);
        int t=accountServiceImpl.update(account);
        if(t==1){
            return account.toString();
        }else {
            return "fail";
        }
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public  String postAccount( @RequestParam(value = "name")String name,
                                @RequestParam(value = "money" )double money){
        Account account=new Account();
        account.setMoney(money);
        account.setName(name);
        int t= accountServiceImpl.add(account);
        if(t==1){
            return account.toString();
        }else {
            return "fail";
        }

    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public  List<Account> getAccounts(){
        return accountServiceImpl.findAccountList();
    }
}
