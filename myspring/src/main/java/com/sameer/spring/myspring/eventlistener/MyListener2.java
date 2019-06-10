package com.sameer.spring.myspring.eventlistener;

import org.springframework.context.ApplicationListener;

public class MyListener2 implements ApplicationListener<BatchEvent> {

	public void onApplicationEvent(BatchEvent event) {
		System.out.println("MyListener2 - onApplicationEvent()");
		System.out.println("Batch event is raised");
		BatchEvent batchEvent =  (BatchEvent)event ;
		System.out.println(batchEvent.getBatch());
	}
}
