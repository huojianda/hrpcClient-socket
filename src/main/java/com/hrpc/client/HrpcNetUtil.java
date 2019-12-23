package com.hrpc.client;

import com.hrpc.api.HrpcRequest;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @author huoji
 * socket 请求服务端
 */
public class HrpcNetUtil {

    private String host;
    private int port;

    public HrpcNetUtil(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public Object sendRequest(HrpcRequest request){
        Socket socket = null;
        Object result = null;
        ObjectOutputStream outputStream = null;
        ObjectInputStream inputStream = null;
        try{
            socket = new Socket(host,port);

            outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(request);
            outputStream.flush();

            inputStream = new ObjectInputStream(socket.getInputStream());
            result = inputStream.readObject();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(outputStream != null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
