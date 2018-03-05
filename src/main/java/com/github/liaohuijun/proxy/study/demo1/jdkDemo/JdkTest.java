package com.github.liaohuijun.proxy.study.demo1.jdkDemo;

import com.github.liaohuijun.proxy.study.demo1.target.ProxyInterface;
import com.github.liaohuijun.proxy.study.demo1.target.ProxyTarget;

/**
 * JDK-测试
  * (用一句话描述类的主要功能)
  * @author LIAO  
  * @date 2018年2月17日
 */
public class JdkTest {

	public static void main(String[] args) {
		
		ProxyInterface target = new ProxyTarget();
		
		ProxyInterface proxy = (ProxyInterface) new ProxyFactory(target).getProxyInstance();
		
		proxy.print();
	}

}
