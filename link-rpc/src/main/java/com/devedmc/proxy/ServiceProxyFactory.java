//-*- coding =utf-8 -*-
//@Time : 2024/6/1
//@Author: 邓闽川
//@File  ServiceProxyFactory.java
//@software:IntelliJ IDEA
package com.devedmc.proxy;

import java.lang.reflect.Proxy;

/**
 * 服务代理工厂,用于创建代理对象
 */
public class ServiceProxyFactory {
    @SuppressWarnings("unchecked")
    public static <T> T getProxy(Class<T> serviceClass){
        return (T) Proxy.newProxyInstance(serviceClass.getClassLoader(),new Class[]{serviceClass},new ServiceProxy());
    }

}
