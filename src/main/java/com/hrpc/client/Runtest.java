package com.hrpc.client;

import com.hrpc.api.IHelloHrpc;

/**
 * @author huoji
 */
public class Runtest {

    public static void main(String[] args) {
        HrpcProxyClient hrpcProxyClient = new HrpcProxyClient();

        IHelloHrpc  helloHrpc = hrpcProxyClient.clientProxy
                (IHelloHrpc.class,"localhost",8080);
        String result = helloHrpc.helloHrpc("hi  , hrpc");

        System.out.println(result);
    }
}
