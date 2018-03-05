package com.github.liaohuijun.proxy.study.demo1.target;

/**
 * 被代理目标
  * (用一句话描述类的主要功能)
  * @author LIAO  
  * @date 2018年2月17日
 */
public class ProxyTarget implements ProxyInterface{
	@Override
	public void print() {
		System.out.println("被代理目标");
	}
}
