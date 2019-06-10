package com.sameer.spring.myspring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sameer.spring.myspring.config.AppConfig3;
import com.sameer.spring.myspring.dto.CustomerDTO;
import com.sameer.spring.myspring.helper.CustomerDAO;

public class AppDataAccess {

	public static void main(String[] args) {
		
		CustomerDTO customerDTO = null ;
		List<CustomerDTO> listCustomer = new ArrayList<CustomerDTO>();
		@SuppressWarnings("resource")
	    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("app-config3.xml");
		//ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig3.class);
        CustomerDAO customerDAO = (CustomerDAO) applicationContext.getBean("customerdao");
        
        //Add Customer
        customerDTO = new CustomerDTO(114, "mm", "mm@gmail.com", 2101, "Blore");
        //customerDAO.addCustomer(customerDTO);
        
        //Delete Customer
        //customerDAO.deleteCustomer(113);
        
        //update Customer
        customerDTO = new CustomerDTO(113, "aa", "aa@gmail.com", 1111, "Blore");
        //customerDAO.updateCustomer(customerDTO);
        
       /* listCustomer = customerDAO.getAllCustomers();
        for(CustomerDTO cust : listCustomer) {
        	System.out.println(cust);
        }*/
        
        customerDTO = customerDAO.getCustomerByCid(114);
        //System.out.println(customerDTO);
        
        customerDTO = customerDAO.getCustomerByEmail("aa@gmail.com");
        //System.out.println(customerDTO);
        
        listCustomer = customerDAO.getCustomerByCity("Pune");
        for(CustomerDTO cust : listCustomer) {
        	System.out.println(cust);
        }
        
        //int count = customerDAO.getCustoomerCount();
        //System.out.println(count);
        
       /* String city = customerDAO.getCustomerCityByEmail("aa@gmail.com");
        System.out.println(city);*/
        
        /*long phone = customerDAO.getCustomerPhoneByEmail("aa@gmail.com");
        System.out.println(phone);*/
	}
}
