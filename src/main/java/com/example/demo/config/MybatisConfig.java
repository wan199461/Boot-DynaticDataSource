package com.example.demo.config;

import java.beans.PropertyVetoException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
public class MybatisConfig {
	
	@Autowired
	private C3p0DataSourcePrimary c3p0DataSource1;
	@Autowired
	private C3p0DataSourceSecondary c3p0DataSource2;
	
	
	@Bean("comboPooledDataSourcePrimary")
	public ComboPooledDataSource comboPooledDataSourcePrimary() throws PropertyVetoException{
		
		System.out.println("##############  Init C3P0.ComboPooledDataSource 1 ####################");
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setDriverClass(c3p0DataSource1.getDriver());
		dataSource.setJdbcUrl(c3p0DataSource1.getUrl());
		dataSource.setUser(c3p0DataSource1.getUser());
		dataSource.setPassword(c3p0DataSource1.getPassWorld());
		dataSource.setMaxPoolSize(c3p0DataSource1.getMaxPoolSize());
		dataSource.setMinPoolSize(c3p0DataSource1.getMinPoolSize());
		dataSource.setInitialPoolSize(c3p0DataSource1.getInitPoolSize());
		dataSource.setMaxIdleTime(c3p0DataSource1.getMaxIdleTime());
		dataSource.setIdleConnectionTestPeriod(c3p0DataSource1.getIdleConnectionTestPeriod());
		return dataSource;
	}
	
	@Bean("comboPooledDataSourceSecondary")
	public ComboPooledDataSource comboPooledDataSourceSecondary() throws PropertyVetoException{
		
		System.out.println("##############  Init C3P0.ComboPooledDataSource 2  ####################");
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setDriverClass(c3p0DataSource2.getDriver());
		dataSource.setJdbcUrl(c3p0DataSource2.getUrl());
		dataSource.setUser(c3p0DataSource2.getUser());
		dataSource.setPassword(c3p0DataSource2.getPassWorld());
		dataSource.setMaxPoolSize(c3p0DataSource2.getMaxPoolSize());
		dataSource.setMinPoolSize(c3p0DataSource2.getMinPoolSize());
		dataSource.setInitialPoolSize(c3p0DataSource2.getInitPoolSize());
		dataSource.setMaxIdleTime(c3p0DataSource2.getMaxIdleTime());
		dataSource.setIdleConnectionTestPeriod(c3p0DataSource2.getIdleConnectionTestPeriod());
		return dataSource;
	}
	
	
	// SqlSessionFactory里的 dataSource 通过这里进行注入
	@Bean
	public DataSource comboPooledDataSource() throws PropertyVetoException{
		
		DynamicDataSource dynamicDataSource = new DynamicDataSource();
		
		//动态数据源的  默认数据源
		dynamicDataSource.setDefaultTargetDataSource(comboPooledDataSourcePrimary());
		
		 // 配置多数据源
        Map<Object, Object> dsMap = new HashMap<Object, Object>(5);
        dsMap.put("DS-primary", comboPooledDataSourcePrimary());
        dsMap.put("DS-secondary", comboPooledDataSourceSecondary());
        
        dynamicDataSource.setTargetDataSources(dsMap);
        
        // 应该是dynamicDataSource在返回实际掌控的数据源时会调用 determineCurrentLookupKey方法，从map中根据key获取所要使用的数据源(如果没获取到则使用默认数据源)。
		return dynamicDataSource;
	}
	
	
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception{
		
		System.out.println("##############  Init org.apache.ibatis.session.SqlSessionFactory  ####################");
		
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(comboPooledDataSource());
		
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		sqlSessionFactory.setMapperLocations(resolver.getResources("classpath:mybatis/mapper/*.xml"));
		sqlSessionFactory.setConfigLocation(resolver.getResource("classpath:mybatis/mybatis-config.xml"));
		
		return sqlSessionFactory.getObject();
	}
	

}










