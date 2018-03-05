package com.github.liaohuijun.proxy.study.demo4.proxy;

public class Test {

	public static void main(String[] args) {
		DogImp dogImp = new DogImp();
		System.out.println(dogImp.getName());
		dogImp.getProperty();
	}
}
