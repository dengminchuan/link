//-*- coding =utf-8 -*-
//@Time : 2024/5/29
//@Author: 邓闽川
//@File  UserServiceImpl.java
//@software:IntelliJ IDEA
package com.devedmc;

import com.devedmc.model.User;
import com.devedmc.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public User getUser(User user) {
        System.out.println("用户名:"+user.getName());
        return user;
    }

    @Override
    public int getAge() {
        return 100;
    }
}
