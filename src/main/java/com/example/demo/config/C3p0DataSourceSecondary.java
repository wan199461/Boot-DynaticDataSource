package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class C3p0DataSourceSecondary {
	
	@Value("${datasource2.c3p0.driverClass}")
	private String driver;
	
	@Value("${datasource2.c3p0.jdbcUrl}")
	private String url;
	
	@Value("${datasource2.c3p0.user}")
	private String user;
	
	@Value("${datasource2.c3p0.password}")
	private String passWorld;
	
	@Value("${datasource2.c3p0.maxPoolSize}")
	private Integer maxPoolSize;
	
	@Value("${datasource2.c3p0.minPoolSize}")
	private Integer minPoolSize;
	
	@Value("${datasource2.c3p0.initialPoolSize}")
	private Integer initPoolSize;
	
	@Value("${datasource2.c3p0.maxIdleTime}")
	private Integer maxIdleTime;
	
	@Value("${datasource2.c3p0.idleConnectionTestPeriod}")
	private Integer idleConnectionTestPeriod;
	

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassWorld() {
		return passWorld;
	}

	public void setPassWorld(String passWorld) {
		this.passWorld = passWorld;
	}

	public Integer getMaxPoolSize() {
		return maxPoolSize;
	}

	public void setMaxPoolSize(Integer maxPoolSize) {
		this.maxPoolSize = maxPoolSize;
	}

	public Integer getMinPoolSize() {
		return minPoolSize;
	}

	public void setMinPoolSize(Integer minPoolSize) {
		this.minPoolSize = minPoolSize;
	}

	public Integer getInitPoolSize() {
		return initPoolSize;
	}

	public void setInitPoolSize(Integer initPoolSize) {
		this.initPoolSize = initPoolSize;
	}

	public Integer getMaxIdleTime() {
		return maxIdleTime;
	}

	public void setMaxIdleTime(Integer maxIdleTime) {
		this.maxIdleTime = maxIdleTime;
	}

	public Integer getIdleConnectionTestPeriod() {
		return idleConnectionTestPeriod;
	}

	public void setIdleConnectionTestPeriod(Integer idleConnectionTestPeriod) {
		this.idleConnectionTestPeriod = idleConnectionTestPeriod;
	}

}
