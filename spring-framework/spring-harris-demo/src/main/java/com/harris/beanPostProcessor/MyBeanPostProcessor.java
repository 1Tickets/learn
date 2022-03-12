package com.harris.beanPostProcessor;

import com.harris.bean.Person;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author Harris
 * @version 1.0
 * @ClassName: spring
 * @Description: bean前后处理器
 * @date 2022/1/17 0:23
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("BeanPostProcessor前置处理器");
		System.out.println("beanName:" + beanName + ",bean:" + bean);
		if (beanName.equals("person")) {
			Person person = (Person) bean;
			person.setName("王五");
		}
		return null;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("BeanPostProcessor后置处理器");
		System.out.println("beanName:" + beanName + ",bean:" + bean);
		return null;
	}
}
