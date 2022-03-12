package com.harris.config;

import com.harris.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @author Harris
 * @version 1.0
 * @ClassName: spring
 * @Description: 配置类
 * @date 2022/1/16 21:16
 */
@Component
@ComponentScan(basePackages = {"com,harris"})
public class AppConfig {

	@Bean(name = "person")
	public Person getPerson () {
	    return new Person("李四", "李先生", 23, 1);
	}

}
