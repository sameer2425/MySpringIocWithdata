package com.sameer.spring.myspring.helper;

import java.util.List;

import com.sameer.spring.myspring.dto.CustomerDTO;

public interface CustomerDAO {

	public void addCustomer(CustomerDTO customerDTO);
	public void updateCustomer(CustomerDTO customerDTO);
	public void deleteCustomer(int cid);
	public List<CustomerDTO> getAllCustomers();
	public CustomerDTO getCustomerByCid(int cid);
	public CustomerDTO getCustomerByEmail(String email);
	public List<CustomerDTO> getCustomerByCity(String city);
	public int getCustoomerCount();
	public String getCustomerCityByEmail(String email);
	public Long getCustomerPhoneByEmail(String email);
}
