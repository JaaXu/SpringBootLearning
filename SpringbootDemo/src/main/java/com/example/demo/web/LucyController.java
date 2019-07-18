package com.example.demo.web;

import com.example.demo.Bean.ConfigBean;
import com.example.demo.Bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableConfigurationProperties({ConfigBean.class,User.class})
public class LucyController {

    @Autowired
    ConfigBean configBean;
    @RequestMapping("/lucy")
    public String miya(){
        return configBean.getGreeting()+">>>"+configBean.getName()+">>>"+configBean.getUuid()+">>>"+configBean.getValue()+">>>"+configBean.getMax();
    }

    @Autowired
    User user;
    @RequestMapping("/user")
    public String user(){
        return user.getName()+":"+user.getAge();
    }
}
