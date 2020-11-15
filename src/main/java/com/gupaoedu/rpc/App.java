package com.gupaoedu.rpc;

import jdk.nashorn.internal.ir.annotations.Reference;

/**
 * Hello world!
 */
public class App {

    //   @Reference  //dubbo代理使用，注解此处不用，手写实现代理
    IHelloService iHelloService;//动态代理

    public void say() {

        iHelloService.sayHello("GuPao");

    }


    public static void main(String[] args) {

        RpcProxyClient client=new RpcProxyClient();
        IHelloService iHelloService = client.clientProxy(IHelloService.class, "localhost", 8080);

        System.out.println(iHelloService.sayHello("GuPap"));



    }
}
