package com.hellobike.demo.dao.impl;

import com.hellobike.demo.dao.IAccountDao;
import com.hellobike.demo.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountDaoImpl implements IAccountDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int add(Account account) {
        return jdbcTemplate.update("insert into  account(name ,money)values(?,?)",
                account.getName(),account.getMoney());
    }

    @Override
    public int update(Account account) {
        return jdbcTemplate.update("UPDATE account SET name=?,money=? where id=?",
        account.getName(),account.getMoney(),account.getId());
    }

    @Override
    public int delete(int id) {
        return jdbcTemplate.update("DELETE  from account where id=?",id);
    }

    @Override
    public Account findAccountById(int id) {
        List<Account> list= jdbcTemplate.query("select * from account where id=?",new Object[]{id},new BeanPropertyRowMapper(Account.class));
       // List<Account> list=jdbcTemplate.query("select * from account where id=?",new BeanPropertyRowMapper(Account.class));
        if(list!=null&&list.size()>0){
            Account account=list.get(0);
            return account;
        }else{
            return null;
        }
    }

    @Override
    public List<Account> findAccountList() {
        List<Account> list= jdbcTemplate.query("select * from account ",new Object[]{},new BeanPropertyRowMapper(Account.class));
        // List<Account> list=jdbcTemplate.query("select * from account where id=?",new BeanPropertyRowMapper(Account.class));
        if(list!=null&&list.size()>0){
            return list;
        }else{
            return null;
        }
    }
}
