package com.example.demo.controller;

import java.security.Principal;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.IExamDao;
import com.example.demo.entity.UserExam;

@Controller
@RequestMapping("/exam1")
public class ExamController {

	@Autowired
	IExamDao ed;

	@GetMapping("/exam")
	public String exampage(Principal principal, Model model) {
		ed.createExamno();
		int examNo = ed.getExamno();
		if (principal != null) {
			String username = principal.getName();
			model.addAttribute("examno", examNo);
			model.addAttribute("username", username);
		}
		return "/exam1/exam";
	}
	
	@PostMapping("/submitExam")
	public String submitExam(
		    @RequestParam("questionno") int[] questionno,
		    @RequestParam("useranswer") String[] useranswer,
		    @RequestParam("examno") int examno,
		    @RequestParam("username") String username) {

	    for (int i = 0; i < questionno.length; i++) {
	        UserExam userExam = new UserExam();
	        userExam.setExamno(examno);
	        userExam.setUsername(username);
	        userExam.setQuestionno(questionno[i]);
	        userExam.setUseranswer(useranswer[i]);
	        ed.submitExam(userExam);
	    }
	    return "/students/mypage";
	}
	
	@GetMapping("/question1page")
	public String exam1page(Principal principal, Model model) {
		ed.createExamno();
		int examNo = ed.getExamno();
		if (principal != null) {
			String username = principal.getName();
			model.addAttribute("examno", examNo);
			model.addAttribute("username", username);
		}
		return "/exam1/question1page";
	}

	@PostMapping("/question1")
	public String exam1(Principal principal, Model model, @RequestParam("examno") int examno,
			@RequestParam("username") String username, @RequestParam("questionno") int questionno,
			@RequestParam("useranswer") String useranswer, @RequestParam("score") int score) {
		UserExam ue = new UserExam();
		ue.setExamno(examno);
		ue.setUsername(username);
		ue.setQuestionno(questionno);
		ue.setUseranswer(useranswer);
		ue.setScore(score);

		ed.insertResult(examno, username, questionno, useranswer, score);

		if (principal != null) {
			ue.setUsername(principal.getName());
			model.addAttribute("examno", ue.getExamno());
			model.addAttribute("username", ue.getUsername());
		}
		return "/exam1/question2page";
	}

	@PostMapping("/question2")
	public String exam2(Principal principal, Model model, @RequestParam("examno") int examno,
			@RequestParam("username") String username, @RequestParam("questionno") int questionno,
			@RequestParam("useranswer") String useranswer, @RequestParam("score") int score) {
		UserExam ue = new UserExam();
		ue.setExamno(examno);
		ue.setUsername(username);
		ue.setQuestionno(questionno);
		ue.setUseranswer(useranswer);
		ue.setScore(score);

		ed.insertResult(examno, username, questionno, useranswer, score);

		if (principal != null) {
			ue.setUsername(principal.getName());
			model.addAttribute("examno", ue.getExamno());
			model.addAttribute("username", ue.getUsername());
		}
		return "/exam1/question3page";
	}

	@PostMapping("/question3")
	public String exam3(Principal principal, Model model, @RequestParam("examno") int examno,
			@RequestParam("username") String username, @RequestParam("questionno") int questionno,
			@RequestParam("useranswer") String useranswer, @RequestParam("score") int score) {
		UserExam ue = new UserExam();
		ue.setExamno(examno);
		ue.setUsername(username);
		ue.setQuestionno(questionno);
		ue.setUseranswer(useranswer);
		ue.setScore(score);

		ed.insertResult(examno, username, questionno, useranswer, score);

		if (principal != null) {
			ue.setUsername(principal.getName());
			model.addAttribute("examno", ue.getExamno());
			model.addAttribute("username", ue.getUsername());
		}
		return "/exam1/question4page";
	}

	@PostMapping("/question4")
	public String exam4(Principal principal, Model model, @RequestParam("examno") int examno,
			@RequestParam("username") String username, @RequestParam("questionno") int questionno,
			@RequestParam("useranswer") String useranswer, @RequestParam("score") int score) {
		UserExam ue = new UserExam();
		ue.setExamno(examno);
		ue.setUsername(username);
		ue.setQuestionno(questionno);
		ue.setUseranswer(useranswer);
		ue.setScore(score);

		ed.insertResult(examno, username, questionno, useranswer, score);

		if (principal != null) {
			ue.setUsername(principal.getName());
			model.addAttribute("examno", ue.getExamno());
			model.addAttribute("username", ue.getUsername());
		}
		return "/exam1/question5page";
	}

	@PostMapping("/question5")
	public String exam5(Principal principal, Model model, @RequestParam("examno") int examno,
			@RequestParam("username") String username, @RequestParam("questionno") int questionno,
			@RequestParam("useranswer") String useranswer, @RequestParam("score") int score) {
		UserExam ue = new UserExam();
		ue.setExamno(examno);
		ue.setUsername(username);
		ue.setQuestionno(questionno);
		ue.setUseranswer(useranswer);
		ue.setScore(score);

		ed.insertResult(examno, username, questionno, useranswer, score);

		if (principal != null) {
			ue.setUsername(principal.getName());
			model.addAttribute("examno", ue.getExamno());
			model.addAttribute("username", ue.getUsername());
		}
		return "/students/mypage";
	}

}
