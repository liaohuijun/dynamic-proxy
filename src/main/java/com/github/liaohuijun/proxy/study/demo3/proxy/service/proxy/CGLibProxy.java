package com.github.liaohuijun.proxy.study.demo3.proxy.service.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 
  * (用一句话描述类的主要功能)
  * @author LIAO  
  * @date 2018年2月17日
 */
public class CGLibProxy implements MethodInterceptor{

    private static CGLibProxy proxy = new CGLibProxy();

    private CGLibProxy(){}

    public static CGLibProxy getInstance(){
        return proxy;
    }

    public <T> T getProxy(Class<T> cls){
        return (T) Enhancer.create(cls, this);
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        begin();
        Object result = proxy.invokeSuper(obj, args);
        end();
        return result;
    }




    public void begin(){
        System.out.println("##begin##");
    }

    public void end(){
        System.out.println("##end##");
    }
}
