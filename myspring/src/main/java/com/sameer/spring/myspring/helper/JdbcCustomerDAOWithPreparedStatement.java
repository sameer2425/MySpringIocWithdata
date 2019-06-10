package com.sameer.spring.myspring.helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.sameer.spring.myspring.dto.CustomerDTO;
import com.sameer.spring.myspring.jdbc.CustomerRowMapper;

public class JdbcCustomerDAOWithPreparedStatement extends JdbcDaoSupport implements CustomerDAO {

	public void addCustomer(final CustomerDTO customerDTO) {
		PreparedStatementCreator preparedStatementCreator = new PreparedStatementCreator() {
			
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement preparedStatement = con.prepareStatement("insert into customers values(?,?,?,?,?)");
				preparedStatement.setInt(1, customerDTO.getCid());
				preparedStatement.setString(2, customerDTO.getCname());
				preparedStatement.setString(3, customerDTO.getEmail());
				preparedStatement.setLong(4, customerDTO.getPhone());
				preparedStatement.setString(5, customerDTO.getCity());
				return preparedStatement;
			}
		};
		getJdbcTemplate().update(preparedStatementCreator);
	}

	public void updateCustomer(CustomerDTO customerDTO) {
		// TODO Auto-generated method stub

	}

	public void deleteCustomer(int cid) {
		// TODO Auto-generated method stub

	}

	public List<CustomerDTO> getAllCustomers() {
		PreparedStatementCreator preparedStatementCreator = new PreparedStatementCreator() {
			
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement peparedStatement = con.prepareStatement("select * from customers");
				return peparedStatement;
			}
		};
		List<CustomerDTO> listCustomer = getJdbcTemplate().query(preparedStatementCreator, new CustomerRowMapper());
		return listCustomer;
	}

	public CustomerDTO getCustomerByCid(int cid) {
		// TODO Auto-generated method stub
		return null;
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
