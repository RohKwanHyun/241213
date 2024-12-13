package com.example.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.entity.User;

@Mapper
public interface IUserDao {

	public void registUser(@Param("user") User user);
	public User findByUsername(String username);
	
}
