package com.harris.circular;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Harris
 * @version 1.0
 * @ClassName: spring
 * @Description: 循环依赖测试
 * @date 2022/3/5 22:23
 */
public class CircularDependenciesDemo {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(CircularConfig.class);

		A bean = applicationContext.getBean(A.class);

		System.out.println(bean);

		applicationContext.close();
	}
}
