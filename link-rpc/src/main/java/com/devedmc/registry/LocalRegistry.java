//-*- coding =utf-8 -*-
//@Time : 2024/5/29
//@Author: 邓闽川
//@File  LocalRegistry.java
//@software:IntelliJ IDEA
package com.devedmc.registry;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 跑通流程的临时本地注册中心
 */
public class LocalRegistry {
    private static final Map<String, Class<?>> map = new ConcurrentHashMap<>();

    public static void register(String serviceName, Class<?> implclass) {
        map.put(serviceName, implclass);
    }

    public static Class<?> get(String serviceName) {
        return map.get(serviceName);
    }

    public static void remove(String serviceName) {
        map.remove(serviceName);
    }
}