package com.github.liaohuijun.proxy.study.demo2;

public class CountServiceImpl implements CountService {

	private int count=0;
	
	@Override
	public int count() {
		
		return count++;
		
	}

}
