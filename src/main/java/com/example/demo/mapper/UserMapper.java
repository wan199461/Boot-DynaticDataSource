package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.domain.UserModel;

@Mapper
public interface UserMapper {
	
	List<UserModel> getUsers();
	
	void changeUserAge(@Param("age")Integer age, @Param("id")Integer id);

}
