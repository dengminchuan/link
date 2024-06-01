//-*- coding =utf-8 -*-
//@Time : 2024/6/1
//@Author: 邓闽川
//@File  ServiceProxy.java
//@software:IntelliJ IDEA
package com.devedmc.proxy;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.devedmc.model.RpcRequest;
import com.devedmc.model.RpcResponse;
import com.devedmc.util.serialize.JdkSerializer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;



public class ServiceProxy implements InvocationHandler {
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
        JdkSerializer serializer = new JdkSerializer();
        RpcRequest rpcRequest =RpcRequest.builder()
                .serviceName(method.getDeclaringClass().getName())
                .methodName(method.getName()).
        parameterTypes(method.getParameterTypes())
                        .args(args)
                        .build();
        byte[] bodyBytes = serializer.serialize(rpcRequest);
        HttpResponse httpResponse = HttpRequest.post("http://localhost:8080")
                .body(bodyBytes)
                .execute();
        byte[] bytes = httpResponse.bodyBytes();
        RpcResponse rpcResponse = serializer.deserialize(bytes, RpcResponse.class);
        return rpcResponse.getData();

    }

    }

