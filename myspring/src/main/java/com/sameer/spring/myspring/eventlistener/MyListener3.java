package com.sameer.spring.myspring.eventlistener;

import org.springframework.context.ApplicationListener;

public class MyListener3 implements ApplicationListener<WorkshopEvent> {

	public void onApplicationEvent(WorkshopEvent event) {
		System.out.println("MyListener3 - onApplicationEvent()");
		System.out.println("WorkshopEvent is raised");
		WorkshopEvent workshopEvent = (WorkshopEvent)event ;
		System.out.println(workshopEvent.getWorkshop());
	}
}
