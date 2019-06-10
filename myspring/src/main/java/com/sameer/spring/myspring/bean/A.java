package com.sameer.spring.myspring.bean;
import javax.annotation.PostConstruct;

public class A {

	private int a ;
	private String msg ;
	static {
		System.out.println("A - S.B");
	}
	public A() {
		System.out.println("A-()");
	}
	public void setA(int a) {
		this.a = a;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	@PostConstruct
	public void inti() {
		System.out.println("A -init()");
	}
	
	@Override
	public String toString() {
		return "A [a=" + a + ", msg=" + msg + "]";
	}
}
