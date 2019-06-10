package com.sameer.spring.myspring.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sameer.spring.myspring.dto.CustomerDTO;

public class CustomerRowMapper implements RowMapper<CustomerDTO> {

	public CustomerDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setCid(rs.getInt(1));
		customerDTO.setCname(rs.getString(2));
		customerDTO.setEmail(rs.getString(3));
		customerDTO.setPhone(rs.getLong(4));
		customerDTO.setCity(rs.getString(5));
		return customerDTO;
	}
}
