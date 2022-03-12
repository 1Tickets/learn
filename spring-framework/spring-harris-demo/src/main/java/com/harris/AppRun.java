package com.harris;

import com.harris.bean.Person;
import com.harris.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Harris
 * @version 1.0
 * @ClassName: spring
 * @Description: spring测试
 * @date 2022/1/16 21:18
 */
public class AppRun {

	public static void main(String[] args) {
		// 创建IOC容器
		AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		Person person = configApplicationContext.getBean(Person.class);
		System.out.println(person.toString());
		configApplicationContext.close();
	}
}
