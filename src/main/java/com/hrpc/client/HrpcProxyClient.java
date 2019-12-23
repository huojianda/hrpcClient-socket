package com.hrpc.client;

import java.lang.reflect.Proxy;

/**
 * @author huoji
 * 使用jdk proxy
 */
public class HrpcProxyClient {

    public <T> T clientProxy(final Class<T> interfaceCls,final String host,final int port){

        return (T)Proxy.newProxyInstance(interfaceCls.getClassLoader(),
                new Class<?>[]{interfaceCls},new HrpcInvocationHandler(host,port));
    }
}
