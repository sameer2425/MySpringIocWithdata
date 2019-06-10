package com.sameer.spring.myspring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

import com.sameer.spring.myspring.bean.DataSource;
import com.sameer.spring.myspring.bean.TestBean1;

@Configuration
@PropertySource(value= {"classpath:common.properties","classpath:oracle.properties","classpath:mysql.properties"})
public class AppConfig {
	
	@Autowired
	private Environment env ;
	
	@Value("${us.pw}")
	private String password ;
	@Value("${us.min}")
	private int min ;
	@Value("${us.max}")
	private int max ;
	@Value("${us.timeout}")
	private int timeout ;
	
	@Bean(name="mysqlDS")
	public DataSource mySqlDataSource() {
		
		DataSource dataSource = new DataSource();
		dataSource.setDriverClass(env.getProperty("mysql.dc"));
		dataSource.setUrl(env.getProperty("mysql.url"));
		dataSource.setUsername(env.getProperty("mysql.un"));
		dataSource.setMax(max);
		dataSource.setMin(min);
		dataSource.setPassword(password);
		dataSource.setTimeout(timeout);
		return dataSource;
	}

	@Bean(name="oracleDS")
	public DataSource oracleDataSource(@Value("${oracle.dc}")String driverClass,@Value("${oracle.url}") String url,@Value("${oracle.un}") String username){
		
		DataSource dataSource = new DataSource();
		dataSource.setDriverClass(driverClass);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setMax(max);
		dataSource.setMin(min);
		dataSource.setPassword(password);
		dataSource.setTimeout(timeout);
		return dataSource;
	}
	
	@Bean
	public TestBean1 test() {
		return new TestBean1();
	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer placeHolderConfiguration() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}
