package com.example.demo.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.IExamDao;
import com.example.demo.dao.IUserDao;
import com.example.demo.entity.UserExam;

@Controller
public class UserController {

	@Autowired
	IUserDao userDao;
	@Autowired
	IExamDao examDao;
	
	@GetMapping("/students/mypage")
	public String mypage() {
		return "students/mypage";
	}
	
	@GetMapping("/students/myscorepage")
	public String getScore(Principal principal, Model model) {
		List<UserExam> yourscore = examDao.getScoreById(principal.getName());
		model.addAttribute("yourscore", yourscore);
		return "students/myscorepage";
	}
	
	@GetMapping("/students/exampage")
	public String examPage() {
		return "students/exampage";
	}
	
	@GetMapping("/teacher/dashboard")
	public String dashboardPage() {
		return "teacher/dashboard";
	}
	
	@GetMapping("/teacher/scorelistpage")
	public String scorelistPage(Principal principal, Model model) {
		List<UserExam> scorelist = examDao.getScoreList();
		model.addAttribute("scorelist", scorelist);
		return "teacher/scorelistpage";
	}

}