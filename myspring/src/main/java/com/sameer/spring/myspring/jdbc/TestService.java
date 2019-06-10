package com.sameer.spring.myspring.jdbc;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import javax.annotation.Resource;

public class TestService {

	@Resource(name="postgresqlDS")
	private DataSource postgresqlDS ;
	
	public void showPostgreInfo() {
		try {
			Connection connection =  postgresqlDS.getConnection();
			DatabaseMetaData databaseMetaData = connection.getMetaData();
			System.out.println(databaseMetaData.getDatabaseProductName());
			System.out.println(databaseMetaData.getDefaultTransactionIsolation());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
