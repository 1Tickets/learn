package com.harris;

import com.harris.bean.Person;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * @author Harris
 * @version 1.0
 * @ClassName: spring
 * @Description: 测试类
 * @date 2022/1/16 21:04
 */

public class AppTest {

	@Test
	public void springTest() {
		BeanFactory bf = new XmlBeanFactory(new ClassPathResource("spring-config.xml"));
		Person person = (Person) bf.getBean("person");
		System.out.println(person.toString());
	}

	@Test
	public void xmlText() {
		ClassPathXmlApplicationContext xmlApplicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
		xmlApplicationContext.close();
	}
}
