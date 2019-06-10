package com.sameer.spring.myspring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.sameer.spring.myspring.bean.Hello;

@Configuration
@Import(HaiConfig.class)
public class HelloConfig {

	/*@Bean(name="hello")
	public Hello getHello() {
		return new Hello();
	}*/
}
