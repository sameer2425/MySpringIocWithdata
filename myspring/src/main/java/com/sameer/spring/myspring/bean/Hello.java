package com.sameer.spring.myspring.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy ;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import javax.annotation.PostConstruct;

public class Hello implements InitializingBean,DisposableBean,BeanNameAware,BeanFactoryAware,ApplicationContextAware{

	int x ;
	String str ;
	String msg ;
	String bname ;
	
	@Autowired
	A aobj ;
	
	B bobj ;
	
	ApplicationContext applicationContext1 ;
	BeanFactory beanFactory1 ;
	
	@Autowired
	BeanFactory beanFactory2 ;
	
	@Autowired
	ApplicationContext applicationContext2 ;
	
	static {
		System.out.println("Hello-S.B");
	}
	
	public Hello(int x) {
		System.out.println("Hello - (int x)");
		this.x = x;
	}
	
	public void setStr(String str) {
		System.out.println("Hello - setStr(String str)");
		this.str = str;
	}

	public void setBobj(B bobj) {
		System.out.println("Hello - setBobj(B bobj)");
		this.bobj = bobj;
	}

	@PostConstruct
	public void init1() {
		System.out.println("Hello-init1()");
		msg = "Welcome to MyWorld";
		if(str==null) {
			str="Hai Guys";
		}
	}
	
	@PostConstruct
	public void inti2() {
		System.out.println("Hello-init2()");
		msg = "Welcome to MyWorld";
		if(str==null) {
			str="Hai Guys";
		}
	}
	
	public void afterPropertiesSet() throws Exception {
		System.out.println("Hello - afterPropertiesSet");
		msg = "Welcome to MyWorld";
		if(str==null) {
			str="Hai Guys";
		}
	}

	public void myInit() {
		System.out.println("Hello - myInit()");
		msg = "Welcome to MyWorld";
		if(str==null) {
			str="Hai Guys";
		}
	}
	public void destroy() throws Exception {
		System.out.println("Hello - destroy()");
	}

	public void setBeanName(String bname) {
		System.out.println("Hello - setBeanName()");
		this.bname = bname;
	}

	public void setBeanFactory(BeanFactory beanFactory1) throws BeansException {
		System.out.println("Hello - setBeanFactory");
		this.beanFactory1 = beanFactory1 ;
	}

	public void setApplicationContext(ApplicationContext applicationContext1) throws BeansException {
		System.out.println("Hello - setApplicationContext");
		this.applicationContext1 = applicationContext1;
	}
	
	public void mycleanup() throws Exception {
		System.out.println("Hello - mycleanup()");
	} 
	
	@PreDestroy
	public void cleanup() {
		System.out.println("Hello - cleanup()");
	}
	
	public void show() {
		System.out.println("Hello - show()");
		System.out.println(x);
		System.out.println(str);
		System.out.println(msg);
		System.out.println(aobj);
		System.out.println(bobj);
		System.out.println("Bean Name is "+ bname);
		System.out.println(beanFactory1);
		System.out.println(applicationContext1);
		System.out.println(beanFactory2);
		System.out.println(applicationContext2);
		System.out.println(applicationContext1 == applicationContext2);
		System.out.println(beanFactory1==beanFactory2);
	}
	
}
