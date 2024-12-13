package com.example.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.entity.Question;

@Mapper
public interface IExamDao {

	public void insert(@Param("Question") Question question);
	
}
