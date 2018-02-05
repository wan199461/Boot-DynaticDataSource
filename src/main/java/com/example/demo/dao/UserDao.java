package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.config.DataSourceContextHolder;
import com.example.demo.domain.UserModel;
import com.example.demo.mapper.UserMapper;

@Service
public class UserDao {
	
	@Autowired
	private UserMapper userMapper;
	
	// 获取数据源2的信息
	public String listDB2UserInfos(){
		// 调用前设置数据源也可以改成AOP + 注解 的方式实现
		DataSourceContextHolder.setDB("DS-secondary");  // 设置要使用的数据源
		List<UserModel> infos = userMapper.getUsers();
		DataSourceContextHolder.clearDB();
		return JSONObject.toJSONString(infos);
	}
	
	// 获取数据源1的信息
	public String listDB1UserInfos(){
		// 调用前设置数据源也可以改成AOP + 注解 的方式实现
		DataSourceContextHolder.setDB("DS-primary");  // 设置要使用的数据源
		List<UserModel> infos = userMapper.getUsers();
		DataSourceContextHolder.clearDB();
		return JSONObject.toJSONString(infos);
	}
	
	// 获取默认数据源的信息
	public String listDBDefaultUserInfos(){
		// 调用前设置数据源也可以改成AOP + 注解 的方式实现
//		DataSourceContextHolder.setDB("DS-primary");  // 设置要使用的数据源
		List<UserModel> infos = userMapper.getUsers();
//		DataSourceContextHolder.clearDB();
		return JSONObject.toJSONString(infos);
	}
	
}
