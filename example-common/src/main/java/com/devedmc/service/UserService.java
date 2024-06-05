//-*- coding =utf-8 -*-
//@Time : 2024/5/29
//@Author: 邓闽川
//@File  UserService.java
//@software:IntelliJ IDEA
package com.devedmc.service;

import com.devedmc.model.User;

public interface UserService {

    User getUser(User user);

    int getAge();
}
