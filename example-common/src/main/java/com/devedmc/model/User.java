//-*- coding =utf-8 -*-
//@Time : 2024/5/29
//@Author: 邓闽川
//@File  User.java
//@software:IntelliJ IDEA
package com.devedmc.model;

import java.io.Serializable;

public class User implements Serializable {

    private String name;


    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

}
