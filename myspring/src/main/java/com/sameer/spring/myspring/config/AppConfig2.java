package com.sameer.spring.myspring.config;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sameer.spring.myspring.bean.Account;
import com.sameer.spring.myspring.bean.Address;
import com.sameer.spring.myspring.bean.Customer;

@Configuration
public class AppConfig2 {

	@Bean
	public List<String> emails(){
		List<String> list = new ArrayList<String>();
		list.add("aa@gmail.com");
		list.add("bb@gmail.com");
		list.add("cc@gmail.com");
		return list;
	}
	
	@Bean
	public Set<Long>phones(){
		Set<Long> set = new LinkedHashSet<Long>();
		set.add(1111L);
		set.add(2222L);
		set.add(3333L);
		return set ;
	}
	
	@Bean(name="refs")
	public Map<String, Long>references(){
		Map<String, Long> refs = new LinkedHashMap<String, Long>();
		refs.put("AA", 11L);
		refs.put("BB", 22L);
		refs.put("CC", 33L);
		return refs;
	}
	
	@Bean(name="myprops")
	public Properties getProperties() {
		Properties prop = new Properties();
		prop.put("AA", 11);
		prop.put("BB", 22);
		prop.put("CC", 33);
		return prop;
	}
	
	@Bean
	public Address address() {
		return new Address("Blore", "BTM", "KA");
	}
	
	@Bean
	public Account account1() {
		Account acc1 = new Account();
		acc1.setAccno(11);
		acc1.setAtype("SA");
		acc1.setBal(10000.0);
		return acc1;
	}
	
	@Bean(name="accounts")
	public List<Account> accounts(){
		List<Account> accounts = new ArrayList<Account>();
		Account acc2 = new Account();
		acc2.setAccno(12);
		acc2.setAtype("FD");
		acc2.setBal(20000.0);
		
		accounts.add(account1());
		accounts.add(acc2);
		return accounts;
	}
	
	@Bean(name="cust")
	public Customer customer(Address add) {
		Customer cust = new Customer(101,"Sameer","Sameer@gmail.com",9999L);
		cust.setAddress(add);
		return cust;
	}
}
