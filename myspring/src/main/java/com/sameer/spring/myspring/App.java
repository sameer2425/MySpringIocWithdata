package com.sameer.spring.myspring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.sameer.spring.myspring.bean.Hello;
import com.sameer.spring.myspring.bean.TestBean;
import com.sameer.spring.myspring.bean.TestBean1;
import com.sameer.spring.myspring.config.AppConfig;
import com.sameer.spring.myspring.config.AppConfig3;
import com.sameer.spring.myspring.eventlistener.Batch;
import com.sameer.spring.myspring.eventlistener.MyManager;
import com.sameer.spring.myspring.eventlistener.Workshop;
import com.sameer.spring.myspring.eventlistener.WorkshopEvent;
import com.sameer.spring.myspring.jdbc.TestService;

public class App 
{
    public static void main( String[] args ){
    	
       /* @SuppressWarnings("resource")
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("app-config3.xml");
        TestService test = (TestService) applicationContext.getBean("test");
        test.showPostgreInfo();*/
    	
        @SuppressWarnings("resource")
		AnnotationConfigApplicationContext applicationContext =  new AnnotationConfigApplicationContext(AppConfig3.class);
    	TestService test = (TestService) applicationContext.getBean("test");
        test.showPostgreInfo();
        
    	
    	/*Resource resource = new ClassPathResource("app-config.xml");
    	BeanFactory beanFactory = new XmlBeanFactory(resource);
    	Hello h = (Hello) beanFactory.getBean("HELLO");
    	h.show();*/ 
    	
    	/*ConfigurableApplicationContext configurableApplicationContext = new ClassPathXmlApplicationContext("app-config3.xml");
    	configurableApplicationContext.start();
    	MyManager myManager =  (MyManager) configurableApplicationContext.getBean("myManager");
    	Batch batch = new Batch("B-24", "28-April-2010", "6.30-8.30", 150);
    	myManager.addBatch(batch);
    	Workshop  workshop = new Workshop("Web Service", 5000,90);
    	myManager.addWorkshop(workshop);
    	configurableApplicationContext.stop();
    	configurableApplicationContext.close();*/
    }
} 