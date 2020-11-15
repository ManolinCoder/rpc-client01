package com.gupaoedu.rpc;


//定义一个传输对象


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class RpcNetTransport {

    private String host;
    private int port;

    public RpcNetTransport(String host, int port) {
        this.host = host;
        this.port = port;
    }


    //dubbo是长链接
    //此处是短连接，
    public Object sendRequest(RpcRequest rpcRequest) {

        Socket socket = null;
        ObjectOutputStream outputStream = null;
        ObjectInputStream inputStream = null;

        try {

            socket = new Socket(host, port);
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(rpcRequest);
            outputStream.flush();
            inputStream = new ObjectInputStream(socket.getInputStream());
            return inputStream.readObject();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //    TODO 关闭连接

        }


        return null;
    }


}
