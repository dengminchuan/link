//-*- coding =utf-8 -*-
//@Time : 2024/6/5
//@Author: 邓闽川
//@File  MockServiceProxy.java
//@software:IntelliJ IDEA
package com.devedmc.proxy;

import com.github.javafaker.Bool;
import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Mock服务代理(JDK实现)
 */
@Slf4j
public class MockServiceProxy implements InvocationHandler {
    /**
     * 调用代理
     * @param proxy the proxy instance that the method was invoked on
     *
     * @param method the {@code Method} instance corresponding to
     * the interface method invoked on the proxy instance.  The declaring
     * class of the {@code Method} object will be the interface that
     * the method was declared in, which may be a superinterface of the
     * proxy interface that the proxy class inherits the method through.
     *
     * @param args an array of objects containing the values of the
     * arguments passed in the method invocation on the proxy instance,
     * or {@code null} if interface method takes no arguments.
     * Arguments of primitive types are wrapped in instances of the
     * appropriate primitive wrapper class, such as
     * {@code java.lang.Integer} or {@code java.lang.Boolean}.
     *
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Class<?> returnType = method.getReturnType();
        log.info("mock invoke,method name:{}",method.getName());
        return getDefaultObject(returnType);
    }

    /**
     * 生成指定类型的默认值对象
     * @param type
     * @return
     */
    private Object getDefaultObject(Class<?> type) {
        Faker faker = new Faker();
        //基本类型
        if(type.isPrimitive()){
            if(type==boolean.class){
                Bool bool = faker.bool();
                log.info("mock boolean type:{}",bool);
                return bool;
            }
            else if(type==short.class){
                return (short)0;
            }else if(type==int.class){
                return 0;
            }else if(type==long.class){
                return 0L;
            }
        }
        //对象类型,使用faker生成
        return null;
    }
}
