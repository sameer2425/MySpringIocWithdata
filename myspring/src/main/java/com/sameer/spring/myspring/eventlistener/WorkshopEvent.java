package com.sameer.spring.myspring.eventlistener;

import org.springframework.context.ApplicationEvent;

public class WorkshopEvent extends ApplicationEvent {

	Workshop workshop ;
	
	public WorkshopEvent(Object source,Workshop workshop) {
		super(source);
		this.workshop = workshop;
	}

	public Workshop getWorkshop() {
		return workshop;
	}
}
