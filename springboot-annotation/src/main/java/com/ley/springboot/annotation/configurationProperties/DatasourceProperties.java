package com.ley.springboot.annotation.configurationProperties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix="datasource")
@PropertySource(value={"classpath:jdbc.properties"})
@Component
public class DatasourceProperties {

	private String username;
	
	private String password;
	
	private String jdbcUrl;
	
	private String driverClassName;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getJdbcUrl() {
		return jdbcUrl;
	}

	public void setJdbcUrl(String jdbcUrl) {
		this.jdbcUrl = jdbcUrl;
	}

	public String getDriverClassName() {
		return driverClassName;
	}

	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}

	@Override
	public String toString() {
		return "DatasourceProperties [username=" + username + ", password=" + password + ", jdbcUrl=" + jdbcUrl
				+ ", driverClassName=" + driverClassName + "]";
	}
}
