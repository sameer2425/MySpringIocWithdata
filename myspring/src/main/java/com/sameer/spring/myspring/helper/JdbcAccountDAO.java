package com.sameer.spring.myspring.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;


public class JdbcAccountDAO implements AccountDAO {

	@Autowired
	JdbcTemplate jdbcTemplate ;
	
	@Autowired
	PlatformTransactionManager platformTransactionManager ;
	
	public void deposit(int accno, double amt) {
		TransactionStatus transactionStatus = null ;
		try {
			TransactionDefinition transactionDefinition = new DefaultTransactionDefinition(TransactionDefinition.PROPAGATION_REQUIRED);
			transactionStatus = platformTransactionManager.getTransaction(transactionDefinition);
			String sql1 = "select bal from accounts where accno=?";
			double cbal = jdbcTemplate.queryForObject(sql1, Double.class, accno);
			cbal = cbal + amt ;
			String sql2 = "update accounts set bal=? where accno=?" ;
			jdbcTemplate.update(sql2, cbal,accno);
			platformTransactionManager.commit(transactionStatus);
			
		}catch(Exception e) {
			e.printStackTrace();
			platformTransactionManager.rollback(transactionStatus);
		}
	}

	public void withdraw(int accno, double amt) {
		TransactionStatus transactionStatus = null ;
		try {
			TransactionDefinition transactionDefinition = new DefaultTransactionDefinition(TransactionDefinition.PROPAGATION_REQUIRED);
			transactionStatus = platformTransactionManager.getTransaction(transactionDefinition);
			
			
			platformTransactionManager.commit(transactionStatus);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void fundsTransfer(int saccno, int daccno, double amt) {
		// TODO Auto-generated method stub

	}

	public double getBalance(int accno) {
		String sql = "select bal from accounts where accno = ?" ;
		double cbal = jdbcTemplate.queryForObject(sql, Double.class, accno);
		return cbal;
	}
}
