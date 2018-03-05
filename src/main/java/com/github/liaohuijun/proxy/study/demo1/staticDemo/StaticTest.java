package com.github.liaohuijun.proxy.study.demo1.staticDemo;

import com.github.liaohuijun.proxy.study.demo1.target.ProxyInterface;
import com.github.liaohuijun.proxy.study.demo1.target.ProxyTarget;

/**
 * 静态代理-测试
  * (用一句话描述类的主要功能)
  * @author LIAO  
  * @date 2018年2月17日
 */
public class StaticTest {

	public static void main(String[] args) {
		ProxyInterface target = new ProxyTarget();
		
		ProxyObject proxy = new ProxyObject(target);
		
		proxy.print();
	}

}
