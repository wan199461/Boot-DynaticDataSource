package com.example.demo.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DataSourceContextHolder {
	
	private static final Log log = LogFactory.getLog(DataSourceContextHolder.class);
	
	public static final String DEFAULT_DS = "DS-primary";
	
	private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();
	
	public static void setDB(String dbType){
		log.debug("切换到数据源:" + dbType);
        contextHolder.set(dbType);
	}
	
    // 获取数据源名
    public static String getDB() {
        return (contextHolder.get());
    }

    // 清除数据源名
    public static void clearDB() {
        contextHolder.remove();
    }

}
