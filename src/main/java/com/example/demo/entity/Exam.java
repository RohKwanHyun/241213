package com.example.demo.entity;

import java.sql.Timestamp;
import java.util.Date;

import lombok.Data;

@Data
public class Exam {

	private int examno;
	private Timestamp examdate;
	
    public void setExamno(int examno) {
        this.examno = examno;
    }
	
}
