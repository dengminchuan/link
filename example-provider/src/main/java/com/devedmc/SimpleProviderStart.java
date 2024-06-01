package com.devedmc;

import com.devedmc.registry.LocalRegistry;
import com.devedmc.server.VertXHttpServer;
import com.devedmc.service.UserService;

public class SimpleProviderStart {
    public static void main(String[] args) {
        LocalRegistry.register(UserService.class.getName(),UserServiceImpl.class);
        VertXHttpServer vertXHttpServer = new VertXHttpServer();
        vertXHttpServer.doStart(8080);
    }
}