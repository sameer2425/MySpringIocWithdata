package com.sameer.spring.myspring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sameer.spring.myspring.bean.Hai;

@Configuration
public class HaiConfig {

	@Bean(name="hai")
	public Hai getHai() {
		return  new Hai();
	}
}
