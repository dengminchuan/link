//-*- coding =utf-8 -*-
//@Time : 2024/5/29
//@Author: 邓闽川
//@File  Serializer.java
//@software:IntelliJ IDEA
package com.devedmc.util.serialize;

import java.io.IOException;

public interface Serializer {
    <T> byte[] serialize(T object) throws IOException;

    <T> T deserialize(byte[] bytes,Class<T> type) throws IOException;


}
