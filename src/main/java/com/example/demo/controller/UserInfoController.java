package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dao.UserDao;

@Controller
public class UserInfoController {
	
	@Autowired
	private UserDao userDao;
	
	@RequestMapping("db2")
	@ResponseBody
	public String DB2Info(){
		
		StringBuilder sb = new StringBuilder();
		sb.append("Db2Info:" + userDao.listDB2UserInfos());
		sb.append("\r\nDb1Info:" + userDao.listDB1UserInfos());
		sb.append("\r\nDbDefaultInfo:" + userDao.listDBDefaultUserInfos());
		return sb.toString();
	}

}
