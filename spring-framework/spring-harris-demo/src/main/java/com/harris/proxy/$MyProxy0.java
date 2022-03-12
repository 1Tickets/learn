//package com.harris.proxy;
//
//import java.lang.reflect.Method;
//
//public class $MyProxy0 implements com.harris.proxy.ProxyInterface {
//	InvocationHandler handler;
//
//	public $MyProxy0(InvocationHandler handler) {
//		this.handler = handler;
//	}
//
//	public void getProxy() throws Throwable {
//		Method method = com.harris.proxy.ProxyInterface.class.getMethod("getProxy", new Class[]{});
//		this.handler.invoke(this, method, null);
//	}
//}