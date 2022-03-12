package com.harris.circular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Harris
 * @version 1.0
 * @ClassName: spring
 * @Description:
 * @date 2022/3/5 22:16
 */
@Component
public class A {

	private B b;

	// 构造注入
	//public A(B b) {
	//	this.b = b;
	//}


	public B getB() {
		return b;
	}

	public void setB(B b) {
		this.b = b;
	}
}
