package com.springboot.test.myform.spring.property;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

interface JdbcData {
	String getDatabaseName();

	void setDatabaseName(String databaseName);

	String getDatabaseJdbcUrl();

	void setDatabaseJdbcUrl(String databaseJdbcUrl);

	String getUser();

	void setUser(String user);

	String getPassword();

	void setPassword(String password);
	
	String getDriverName();

	void setDriverName(String driverName);

	String getJpaDatabasePlatForm();

	void setJpaDatabasePlatForm(String JpaDatabasePlatForm);
}

@Component
public class JdbcProperty {

	@Value(value = "${spring.datasource.name}")
	private String databaseName;

	@Value(value = "${spring.datasource.url}")
	private String databaseJdbcUrl;

	@Value(value = "${spring.datasource.username}")
	private String user;

	@Value(value = "${spring.datasource.password}")
	private String password;

	@Value(value = "${spring.datasource.driver-class-name}")
	private String driverName;

	@Value(value = "${spring.jpa.database-platform}")
	private String jpaDatabasePlatForm;

	public String getDatabaseName() {
		return databaseName;
	}

	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}

	public String getDatabaseJdbcUrl() {
		return databaseJdbcUrl;
	}

	public void setDatabaseJdbcUrl(String databaseJdbcUrl) {
		this.databaseJdbcUrl = databaseJdbcUrl;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getJpaDatabasePlatForm() {
		return jpaDatabasePlatForm;
	}

	public void setJpaDatabasePlatForm(String jpaDatabasePlatForm) {
		this.jpaDatabasePlatForm = jpaDatabasePlatForm;
	}
}
