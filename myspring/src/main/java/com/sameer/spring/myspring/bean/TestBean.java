package com.sameer.spring.myspring.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public class TestBean {

	@Autowired
	ApplicationContext applicationContext = null ;
	
	public void showEnglish() {
		String m1 = applicationContext.getMessage("username.required", null, null);
		System.out.println(m1);
		String m2 = applicationContext.getMessage("password.required", new Object[] {"Passowrd"},null);
		System.out.println(m2);
		String m3 = applicationContext.getMessage("errors.min", new Object[] {"Username","5"},null);
		System.out.println(m3);
		String m4 = applicationContext.getMessage("errors.max", new Object[] {"Username","10"},null);
		System.out.println(m4);
		String m5 = applicationContext.getMessage("errors.range", new Object[] {"Password","6","12"},null);
		System.out.println(m5);
	}
}
