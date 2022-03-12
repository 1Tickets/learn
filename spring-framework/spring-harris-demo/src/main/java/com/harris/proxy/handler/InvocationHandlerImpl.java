package com.harris.proxy.handler;

import com.harris.bean.Person;
import com.harris.proxy.InvocationHandler;
import com.harris.proxy.ProxyInterface;

import java.lang.reflect.Method;

/**
 * @author Harris
 * @version 1.0
 * @ClassName: spring
 * @Description: 实现InvocationHandler的业务处理类
 * @date 2022/1/17 20:12
 */
public class InvocationHandlerImpl implements InvocationHandler {

	private ProxyInterface proxyInterface;

	public InvocationHandlerImpl(ProxyInterface proxyInterface) {
		this.proxyInterface = proxyInterface;
	}

	public void before() {
		System.out.println("自定义InvocationHandlerImpl实现执行前");
	}

	public void after() {
		System.out.println("自定义InvocationHandlerImpl实现执行后");
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		before();
		Object invoke = method.invoke(proxyInterface, args);
		after();
		return invoke;
	}
}
