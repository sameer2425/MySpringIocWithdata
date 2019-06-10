package com.sameer.spring.myspring.bean;

import javax.annotation.PostConstruct;

public class B {

	private int b;
	private String str ;
	
	static {
		System.out.println("B-S.B");
	}
	public B() {
		System.out.println("B()");
	}
	public B(int b, String str) {
		super();
		this.b = b;
		this.str = str;
	}
	
	@PostConstruct
	public void inti() {
		System.out.println("B -init()");
	}
	@Override
	public String toString() {
		return "B [b=" + b + ", str=" + str + "]";
	}
}
