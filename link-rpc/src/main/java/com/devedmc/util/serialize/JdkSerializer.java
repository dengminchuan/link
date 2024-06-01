//-*- coding =utf-8 -*-
//@Time : 2024/5/29
//@Author: 邓闽川
//@File  JdkSerializer.java
//@software:IntelliJ IDEA
package com.devedmc.util.serialize;

import java.io.*;

public class JdkSerializer implements Serializer{
    @Override
    public <T> byte[] serialize(T object) throws IOException {
        ByteArrayOutputStream outputStream =new ByteArrayOutputStream();
        ObjectOutputStream objectoutputstream =new ObjectOutputStream(outputStream);
        objectoutputstream.writeObject(object);
        objectoutputstream.close();
        return outputStream.toByteArray();
    }

    @Override
    public <T> T deserialize(byte[] bytes, Class<T> type) throws IOException {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
        ObjectInputStream objectInputstream = new ObjectInputStream(inputStream);
        try {
            return (T) objectInputstream.readObject();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            objectInputstream.close();
        }
    }



}
