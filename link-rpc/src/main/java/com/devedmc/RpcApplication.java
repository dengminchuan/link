//-*- coding =utf-8 -*-
//@Time : 2024/6/3
//@Author: 邓闽川
//@File  RpcApplication.java
//@software:IntelliJ IDEA
package com.devedmc;

import com.devedmc.config.RpcConfig;
import com.devedmc.constant.RpcConstant;
import com.devedmc.util.config.ConfigUtils;
import lombok.extern.slf4j.Slf4j;

/**
 * 存放全局用到的变量,双检锁单例模式实现
 */
@Slf4j
public class RpcApplication {

    private static volatile RpcConfig rpcConfig;

    /**
     * 框架初始化,支持传入配置
     * @param newRpcConfig
     */
    public static void init(RpcConfig newRpcConfig){
        rpcConfig=newRpcConfig;
        log.info("rpc init,config={}",newRpcConfig.toString());
    }

    /**
     * 加载配置初始化
     */
    public static void init(){
           RpcConfig newRpcConfig;
        try {
            newRpcConfig= ConfigUtils.loadConfig(RpcConfig.class, RpcConstant.DEFAULT_CONFIG_PREFIX);
        } catch (Exception e) {
            newRpcConfig=new RpcConfig();
            log.info("load config error,use default config:{}",newRpcConfig.toString());
        }
        init(newRpcConfig);

    }
    public static RpcConfig getRpcConfig(){
        if(rpcConfig==null){
            synchronized (RpcApplication.class){
                if(rpcConfig==null){
                    init();
                }
            }
        }
        return rpcConfig;
    }


}
