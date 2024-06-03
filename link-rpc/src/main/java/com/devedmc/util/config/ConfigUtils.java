//-*- coding =utf-8 -*-
//@Time : 2024/6/3
//@Author: 邓闽川
//@File  ConfigUtils.java
//@software:IntelliJ IDEA
package com.devedmc.util.config;

import cn.hutool.core.util.StrUtil;
import cn.hutool.setting.dialect.Props;

/**
 * 配置工具类
 */
public class ConfigUtils {
    /**
     * 加载配置对象
     * @param tClass
     * @param prefix
     * @return
     * @param <T>
     */
    public static <T> T loadConfig(Class <T> tClass,String prefix){
        return loadConfig(tClass,prefix,"");
    }

    /**
     * 支持区分环境加载配置对象
     * @param tClass
     * @param prefix
     * @param environment
     * @return
     * @param <T>
     */
    private static <T> T loadConfig(Class<T> tClass, String prefix, String environment) {
        StringBuilder configFileStr = new StringBuilder("application");
        if(StrUtil.isNotBlank(environment)){
            configFileStr.append("-").append(environment);
        }
        configFileStr.append(".properties");
        Props props = new Props(configFileStr.toString());
        return props.toBean(tClass,prefix);
    }


}
