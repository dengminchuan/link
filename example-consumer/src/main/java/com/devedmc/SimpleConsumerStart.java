package com.devedmc;

import com.devedmc.config.RpcConfig;
import com.devedmc.model.User;
import com.devedmc.proxy.ServiceProxyFactory;
import com.devedmc.service.UserService;
import com.devedmc.util.config.ConfigUtils;

public class SimpleConsumerStart {
    public static void main(String[] args) {
//        UserService userService= ServiceProxyFactory.getProxy(UserService.class);
//        User user = new User();
//        user.setName("test");
//        User obtainUser = userService.getUser(user);
//        if(obtainUser!=null){
//            System.out.println(obtainUser);
//        }else{
//            System.out.println("null");
//        }
        RpcConfig rpc = ConfigUtils.loadConfig(RpcConfig.class, "lrpc");
        System.out.println(rpc);
    }
}