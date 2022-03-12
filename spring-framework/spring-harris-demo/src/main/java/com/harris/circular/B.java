package com.harris.circular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Harris
 * @version 1.0
 * @ClassName: spring
 * @Description:
 * @date 2022/3/5 22:17
 */
@Component
public class B {

	private A a;

	// 构造注入
	//public B(A a) {
	//	this.a = a;
	//}


	public A getA() {
		return a;
	}

	public void setA(A a) {
		this.a = a;
	}
}
