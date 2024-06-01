//-*- coding =utf-8 -*-
//@Time : 2024/5/30
//@Author: 邓闽川
//@File  RpcResponse.java
//@software:IntelliJ IDEA
package com.devedmc.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RpcResponse implements Serializable {
    /**
     * 响应数据
     */
    private Object data;
    /**
     * 响应数据类型
     */
    private Class<?> dataType;
    /**
     * 响应信息
     */
    private String message;
    /**
     * 异常信息
     */
    private Exception exception;
}