package com.harris.proxy;

import com.harris.bean.Person;
import com.harris.proxy.classloader.ProxyClassLoader;
import com.harris.proxy.handler.InvocationHandlerImpl;

/**
 * @author Harris
 * @version 1.0
 * @ClassName: spring
 * @Description: 代理测试类
 * @date 2022/1/19 23:48
 */
public class MyProxyTestJava {

	static final String filePath = "D:\\WorkSpaces\\spring-framework\\spring-harris-demo\\src\\main\\java\\com\\harris\\proxy";

	public static void main(String[] args) throws Throwable {
		ProxyInterface proxyInterface = new ProxyInterfaceImpl();
		InvocationHandler handler = new InvocationHandlerImpl(proxyInterface);
		ProxyInterface proxyPerson = (ProxyInterface) MyProxy.newProxyInstance(
				new ProxyClassLoader(filePath, "proxy"), ProxyInterface.class, handler);
		System.out.println(proxyPerson.getClass().getName());
		proxyPerson.getProxy();
	}
}
