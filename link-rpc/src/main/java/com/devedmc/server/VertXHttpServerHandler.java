//-*- coding =utf-8 -*-
//@Time : 2024/5/30
//@Author: 邓闽川
//@File  VertXHttpServerHandler.java
//@software:IntelliJ IDEA
package com.devedmc.server;

import com.devedmc.model.RpcRequest;
import com.devedmc.model.RpcResponse;
import com.devedmc.registry.LocalRegistry;
import com.devedmc.util.serialize.JdkSerializer;
import com.devedmc.util.serialize.Serializer;
import io.vertx.core.Handler;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.http.HttpServerResponse;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * vertX的Http Handler
 */
public class VertXHttpServerHandler implements Handler<HttpServerRequest> {
    @Override
    public void handle(HttpServerRequest httpServerRequest) {
        final Serializer jdkSerializer = new JdkSerializer();
        httpServerRequest.bodyHandler(body->{
            byte[] bytes = body.getBytes();
            RpcRequest rpcRequest=null;
            try {
                rpcRequest=jdkSerializer.deserialize(bytes, RpcRequest.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
            RpcResponse rpcResponse = new RpcResponse();
            if(rpcRequest==null){
                rpcResponse.setMessage("rpcRequest is null");
                doResponse(httpServerRequest,rpcResponse,jdkSerializer);
                return;
            }
            Class<?> implClass = LocalRegistry.get(rpcRequest.getServiceName());
            try {
                Method method = implClass.getMethod(rpcRequest.getMethodName(), rpcRequest.getParameterTypes());
                Object result = method.invoke(implClass.newInstance(), rpcRequest.getArgs());
                rpcResponse.setData(result);
                rpcResponse.setDataType(method.getReturnType());
                rpcResponse.setMessage("ok");

            } catch (Exception e) {
                e.printStackTrace();
                rpcResponse.setMessage(e.getMessage());
                rpcResponse.setException(e);
            }
            doResponse(httpServerRequest,rpcResponse,jdkSerializer);

        });
    }

    private void doResponse(HttpServerRequest httpServerRequest, RpcResponse rpcResponse, Serializer serializer) {
        HttpServerResponse httpServerResponse = httpServerRequest.response().putHeader("content-type", "application/json");
        try {
            byte[]  serialized = serializer.serialize(rpcResponse);
            httpServerResponse.end(Buffer.buffer(serialized));
        } catch (IOException e) {
            e.printStackTrace();
            httpServerResponse.end(Buffer.buffer());
        }
    }
}
