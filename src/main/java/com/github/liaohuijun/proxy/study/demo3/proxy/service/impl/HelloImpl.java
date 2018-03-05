package com.github.liaohuijun.proxy.study.demo3.proxy.service.impl;

import com.github.liaohuijun.proxy.study.demo3.proxy.service.Hello;

/**
 * 
  * (用一句话描述类的主要功能)
  * @author LIAO  
  * @date 2018年2月17日
 */
public class HelloImpl implements Hello {
    @Override
    public void say(String name) {
        System.out.println("Hello " + name + "！！！");
    }
}
