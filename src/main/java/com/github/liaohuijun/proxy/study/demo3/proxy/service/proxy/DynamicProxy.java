package com.github.liaohuijun.proxy.study.demo3.proxy.service.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 
  * (用一句话描述类的主要功能)
  * @author LIAO  
  * @date 2018年2月17日
 */
public class DynamicProxy implements InvocationHandler {

    private Object target;

    private DynamicProxy(){}

    public DynamicProxy(Object target){
        this.target = target;
    }

    public <T> T getProxy(){
        return (T) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        begin();
        Object object = method.invoke(target, args);
        end();
        return null;
    }

    private void begin(){
        System.out.println("**begin**");
    }

    private void end(){
        System.out.println("**end**");
    }
}
