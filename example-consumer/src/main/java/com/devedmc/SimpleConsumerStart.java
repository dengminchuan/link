package com.devedmc;

import com.devedmc.model.User;
import com.devedmc.proxy.ServiceProxyFactory;
import com.devedmc.service.UserService;

public class SimpleConsumerStart {
    public static void main(String[] args) {
        UserService userService= ServiceProxyFactory.getProxy(UserService.class);
        User user = new User();
        user.setName("test");
        User obtainUser = userService.getUser(user);
        if(obtainUser!=null){
            System.out.println(obtainUser);
        }else{
            System.out.println("null");
        }
    }
}