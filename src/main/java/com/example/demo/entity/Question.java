package com.example.demo.entity;

import lombok.Data;

@Data
public class Question {

	private int questionno;
	private int examno;
	private int score;
	private int level;
	private String question;
	private String answer;
	
}
