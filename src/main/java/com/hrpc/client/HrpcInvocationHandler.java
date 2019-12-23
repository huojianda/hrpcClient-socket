package com.hrpc.client;

import com.hrpc.api.HrpcRequest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class HrpcInvocationHandler implements InvocationHandler {


    private String host;
    private int port;

    public HrpcInvocationHandler(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("this is a log");

        HrpcRequest hrpcRequest = new HrpcRequest();
        hrpcRequest.setClassName(method.getDeclaringClass().getName());
        hrpcRequest.setMethodName(method.getName());
        hrpcRequest.setParameters(args);

        HrpcNetUtil netUtil = new HrpcNetUtil(host,port);

        Object result = netUtil.sendRequest(hrpcRequest);
        return result;
    }
}
