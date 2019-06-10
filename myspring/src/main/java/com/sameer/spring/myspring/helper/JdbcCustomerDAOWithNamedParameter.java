package com.sameer.spring.myspring.helper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.sameer.spring.myspring.dto.CustomerDTO;
import com.sameer.spring.myspring.jdbc.CustomerRowMapper;

public class JdbcCustomerDAOWithNamedParameter implements CustomerDAO {

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate ;
	
	public void addCustomer(CustomerDTO customerDTO) {
		String sql = "insert into customers values(:cid,:cname,:email,:phone,:city)";
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("cid", customerDTO.getCid());
		parameters.put("cname", customerDTO.getCname());
		parameters.put("email", customerDTO.getEmail());
		parameters.put("phone", customerDTO.getPhone());
		parameters.put("city", customerDTO.getCity());
		namedParameterJdbcTemplate.update(sql, parameters);
	}

	public void updateCustomer(CustomerDTO customerDTO) {
		String sql = "update customers set cname=:cname,email=:email,phone=:phone,city=:city where cid=:cid";
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("cname", customerDTO.getCname());
		parameters.put("email", customerDTO.getEmail());
		parameters.put("phone", customerDTO.getPhone());
		parameters.put("city", customerDTO.getCity());
		parameters.put("cid", customerDTO.getCid());
		namedParameterJdbcTemplate.update(sql, parameters);
	}

	public void deleteCustomer(int cid) {
		String sql = "delete from customers where cid=:cid";
		Map<String, Object>parameters = new HashMap<String, Object>();
		parameters.put("cid", cid);
		namedParameterJdbcTemplate.update(sql, parameters);
	}

	public List<CustomerDTO> getAllCustomers() {
		String sql = "select * from customers" ;
		Map<String, ?> map = null ;
		List<CustomerDTO> list = namedParameterJdbcTemplate.query(sql, map, new CustomerRowMapper());
		return list;
	}

	public CustomerDTO getCustomerByCid(int cid) {
		String sql = "select * from customers where cid=:cid";
		SqlParameterSource parameters = new MapSqlParameterSource("cid", cid);
		CustomerDTO customerDTO = namedParameterJdbcTemplate.queryForObject(sql, parameters, new CustomerRowMapper());
		return customerDTO;
	}

	public CustomerDTO getCustomerByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<CustomerDTO> getCustomerByCity(String city) {
		// TODO Auto-generated method stub
		return null;
	}

	public int getCustoomerCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getCustomerCityByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long getCustomerPhoneByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}
}
