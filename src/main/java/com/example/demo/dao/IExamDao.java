package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.entity.Question;
import com.example.demo.entity.UserExam;

@Mapper
public interface IExamDao {

	public void insert(@Param("Question") Question question);
	public List<UserExam> getScoreById(@Param("username") String username);
	public List<UserExam> getScoreList();
	public void insertResult(@Param("examno") int examno, @Param("username") String username, @Param("questionno") int questionno, @Param("useranswer") String useranswer, @Param("score") int score);
	public void submitExam(@Param("Userexam") UserExam userexam);
	public void createExamno();
	public int getExamno();
}
