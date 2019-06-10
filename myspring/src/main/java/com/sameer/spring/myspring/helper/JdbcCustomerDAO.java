package com.sameer.spring.myspring.helper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sameer.spring.myspring.bean.Customer;
import com.sameer.spring.myspring.dto.CustomerDTO;
import com.sameer.spring.myspring.jdbc.CustomerRowMapper;

@Repository("customerdao")
public class JdbcCustomerDAO implements CustomerDAO {

	@Autowired
	JdbcTemplate jdbcTemplate ; 
	
	public void addCustomer(CustomerDTO customerDTO) {
		String sql = "insert into customers values(?,?,?,?,?)";
		jdbcTemplate.update(sql, customerDTO.getCid(),customerDTO.getCname(),customerDTO.getEmail(),customerDTO.getPhone(),customerDTO.getCity());
	}

	public void updateCustomer(CustomerDTO customerDTO) {
		String sql = "update customers set cname=?,email=?,phone=?,city=? where cid=?";
		jdbcTemplate.update(sql, customerDTO.getCname(),customerDTO.getEmail(),customerDTO.getPhone(),customerDTO.getCity(),customerDTO.getCid());
	}

	public void deleteCustomer(int cid) {
		String sql = "delete from customers where cid=?";
		jdbcTemplate.update(sql, cid);
	}

	public List<CustomerDTO> getAllCustomers() {
		String sql = "select * from customers";
		List<CustomerDTO>listCustomerDTO = jdbcTemplate.query(sql, new CustomerRowMapper());
		return listCustomerDTO;
	}

	public CustomerDTO getCustomerByCid(int cid) {
		String sql = "select * from customers where cid=?";
		CustomerDTO customerDTO = jdbcTemplate.queryForObject(sql, new CustomerRowMapper(),cid);
		return customerDTO;
	}

	public CustomerDTO getCustomerByEmail(String email) {
		String sql = "select * from customers where email=?";
		CustomerDTO customerDTO = jdbcTemplate.queryForObject(sql, new CustomerRowMapper(),email);
		return customerDTO;
	}

	public List<CustomerDTO> getCustomerByCity(String city) {
		String sql = "select * from customers where city=?";
		List<CustomerDTO> listCustomerDTO = jdbcTemplate.query(sql, new CustomerRowMapper(),city);
		return listCustomerDTO;
	}

	public int getCustoomerCount() {
		String sql = "select count(*) from customers";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	public String getCustomerCityByEmail(String email) {
		String sql = "select city from customers where email=?";
		String city = jdbcTemplate.queryForObject(sql, String.class,email);
		return city;
	}

	public Long getCustomerPhoneByEmail(String email) {
		String sql = "select phone from customers where email=?";
		Long phone = jdbcTemplate.queryForObject(sql, Long.class,email);
		return phone;
	}
}
