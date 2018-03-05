package com.github.liaohuijun.proxy.study.demo3.proxy.service.proxy;

import com.github.liaohuijun.proxy.study.demo3.proxy.service.Hello;
import com.github.liaohuijun.proxy.study.demo3.proxy.service.impl.HelloImpl;
/**
 * 
  * (用一句话描述类的主要功能)
  * @author LIAO  
  * @date 2018年2月17日
 */
public class HelloProxy implements Hello{
    private Hello proxy;

    public HelloProxy(){
        proxy = new HelloImpl();
    }

    @Override
    public void say(String name) {
        begin();
        proxy.say(name);
        end();
    }

    private void begin(){
        System.out.println("--begin--");
    }

    private void end(){
        System.out.println("--end--");
    }
}
