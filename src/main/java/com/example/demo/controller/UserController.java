package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.IUserDao;

@Controller
public class UserController {

	@Autowired
	IUserDao userDao;
	
	@GetMapping("/mypage")
	public String mypage() {
		return "mypage";
	}
	
	@GetMapping("/myscorepage")
	public String getScore() {
		return "myscorepage";
	}
	
}
