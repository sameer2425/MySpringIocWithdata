package com.sameer.spring.myspring.eventlistener;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MyManager implements ApplicationContextAware {

	ApplicationContext applicationContext ; 
	
	public void addBatch(Batch batch) {
		applicationContext.publishEvent(new BatchEvent(this, batch));
	}
	
	public void addWorkshop(Workshop workshop) {
		applicationContext.publishEvent(new WorkshopEvent(this, workshop));
	}
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
}
