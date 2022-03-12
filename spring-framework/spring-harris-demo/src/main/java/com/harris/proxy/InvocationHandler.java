package com.harris.proxy;

import java.lang.reflect.Method;

/**
 * @author Harris
 * @version 1.0
 * @ClassName: spring
 * @Description: 自定义InvocationHandler
 * @date 2022/1/17 20:09
 */
public interface InvocationHandler {
	
	Object invoke (Object proxy, Method method, Object[] args) throws Throwable;
}
