package com.github.liaohuijun.proxy.study.demo2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.DecimalFormat;

import net.sf.cglib.core.AbstractClassGenerator;
import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * jdk动态代理和cglib动态代理的对比
  * (用一句话描述类的主要功能)
  * @author LIAO  
  * @date 2018年2月17日
 */
public class DynamicPorxyPerformanceTest {
	
	public static void main(String []args){
		System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\server");
		CountService delegate=new CountServiceImpl();
		
		long time=System.currentTimeMillis();
		CountService jdkProxy=createJdkDynamicProxy(delegate);
		time=System.currentTimeMillis()-time;
		System.out.println("Create JDK Proxy:"+time+"ms");
		
		time=System.currentTimeMillis();
		CountService cglibProxy=createCglibDynamicProxy(delegate);
		time=System.currentTimeMillis()-time;
		System.out.println("Create Cglib Proxy:"+time+"ms");
		
		for(int i=0;i<2;i++){
			System.out.println("---------------");
			test(jdkProxy,"Run JDK Proxy:");
			test(cglibProxy,"Run Cglib Proxy:");
		}
	}
	
	private static void test(CountService service,String label){
		service.count();
		int count=10000000;
		long time=System.currentTimeMillis();
		for(int i=0;i<count;i++)
			service.count();
		time=System.currentTimeMillis()-time;
		System.out.println(label+time+"ms,"+new DecimalFormat().format(count*1000/time)+"t/s");
	}
	
	private static CountService createJdkDynamicProxy(CountService delegate){
		CountService jdkProxy=(CountService)Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),new Class[]{CountService.class},new JdkHandler(delegate));
		return jdkProxy;
	}
	
	private static class JdkHandler implements InvocationHandler{

		private Object delegate;
		public JdkHandler(Object delegate){
			this.delegate=delegate;
		}
		@Override
		public Object invoke(Object proxy, Method method, Object[] args)
				throws Throwable {
			// TODO Auto-generated method stub
			return method.invoke(delegate, args);
		}
	}
	
	private static CountService createCglibDynamicProxy(final CountService delegate){
		Enhancer enhancer=new Enhancer();
		enhancer.setUseCache(false);
		enhancer.setCallback(new CglibInterceptor(delegate));
		enhancer.setInterfaces(new Class[]{CountService.class});
		CountService cglibProxy=(CountService)enhancer.create();
		return cglibProxy;
	}
	
	private static class CglibInterceptor implements MethodInterceptor{
		
		private Object delegate;
		
		public CglibInterceptor(Object delegate){
			this.delegate=delegate;
		}
		
		@Override
		public Object intercept(Object obj, Method m, Object[] args,
				MethodProxy proxy) throws Throwable {
			// TODO Auto-generated method stub
			System.out.println("cglib proxy");
			return proxy.invoke(delegate,args);
		}
	}
	
}
