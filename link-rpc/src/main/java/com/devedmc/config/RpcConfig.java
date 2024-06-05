//-*- coding =utf-8 -*-
//@Time : 2024/6/3
//@Author: 邓闽川
//@File  RpcConfig.java
//@software:IntelliJ IDEA
package com.devedmc.config;

import lombok.Data;

@Data
public class RpcConfig {
    /**
     * 名称
     */
    private String name="link-rpc";

    /**
     * 版本号
     */
    private String version="1.0";
    /**
     * 服务器主机名
     */
    private String serverHost="localhost";
    /**
     * 服务器端口号
     */
    private Integer serverPort=8080;
    /**
     * 是否开启mock服务
     */
    private Boolean mock=false;
}
