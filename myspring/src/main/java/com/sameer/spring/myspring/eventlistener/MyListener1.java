package com.sameer.spring.myspring.eventlistener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class MyListener1 implements ApplicationListener {

	public void onApplicationEvent(ApplicationEvent event) {
		if (event instanceof BatchEvent) {
			BatchEvent batchEvent = (BatchEvent) event;
			Batch batch = batchEvent.getBatch();
			System.out.println(batch);
		}

		else if (event instanceof WorkshopEvent) {
			WorkshopEvent workshopEvent = (WorkshopEvent) event;
			Workshop workshop = workshopEvent.getWorkshop();
			System.out.println(workshop);
		} else {
			System.out.println(event);
		}
	}
}
