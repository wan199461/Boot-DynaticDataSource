package com.example.demo.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource {

	public static final Log log = LogFactory.getLog(DynamicDataSource.class);
	
	@Override
	protected Object determineCurrentLookupKey() {
		 log.debug("数据源为:" + DataSourceContextHolder.getDB());
	     return DataSourceContextHolder.getDB();       // 返回数据源名称
	}
	
	

}
