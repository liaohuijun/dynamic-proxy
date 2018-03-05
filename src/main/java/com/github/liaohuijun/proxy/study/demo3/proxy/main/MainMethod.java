package com.github.liaohuijun.proxy.study.demo3.proxy.main;


import java.lang.reflect.Proxy;

import com.github.liaohuijun.proxy.study.demo3.proxy.service.impl.HelloImpl;
import com.github.liaohuijun.proxy.study.demo3.proxy.service.proxy.CGLibProxy;

/**
 * 
  * (用一句话描述类的主要功能)
  * @author LIAO  
  * @date 2018年2月17日
 */
public class MainMethod {
    public static void main(String args[]){
//        Hello h = new HelloImpl();
//        h.say("orc");
//
//        HelloProxy proxy = new HelloProxy();
//        proxy.say("orclh");
//
//        DynamicProxy proxy1 = new DynamicProxy(new HelloImpl());
//        Hello helloProxy = proxy1.getProxy();
//        helloProxy.say("lh");


        HelloImpl hi = CGLibProxy.getInstance().getProxy(HelloImpl.class);
        hi.say("orc");
    }
}
