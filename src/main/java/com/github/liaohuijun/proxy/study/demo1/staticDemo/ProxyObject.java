package com.github.liaohuijun.proxy.study.demo1.staticDemo;

import com.github.liaohuijun.proxy.study.demo1.target.ProxyInterface;

/**
 * 静态代理-代理对象
  * (用一句话描述类的主要功能)
  * @author LIAO  
  * @date 2018年2月17日
 */
public class ProxyObject implements ProxyInterface{
	
	private ProxyInterface target;
	
	public ProxyObject(ProxyInterface target) {
		this.target = target;
	}
	
	@Override
	public void print() {
		System.out.println("11");
		target.print();
		System.out.println("22");
	}

}
