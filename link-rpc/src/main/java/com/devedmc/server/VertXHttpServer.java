//-*- coding =utf-8 -*-
//@Time : 2024/5/29
//@Author: 邓闽川
//@File  VertXHttpServer.java
//@software:IntelliJ IDEA
package com.devedmc.server;

import io.vertx.core.Vertx;

public class VertXHttpServer implements HttpServer{
    @Override
    public void doStart(int port) {
        Vertx vertx = Vertx.vertx();
        io.vertx.core.http.HttpServer httpServer = vertx.createHttpServer();
        httpServer.requestHandler(new VertXHttpServerHandler());
        httpServer.listen(port,result->{
            if(result.succeeded()){
                System.out.println("server is now listening on port:"+port);
            }else{
                System.out.println("failed to start:"+result.cause());
            }
        });
    }
}
