package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@Controller
public class MainController {
	
	@Autowired
	private UserService us;

	@GetMapping("/")
	public String root() {
		return "main";
	}
	
	@GetMapping("/registForm")
	public String registForm() {
		return "registForm";
	}
	
	@PostMapping("/registProc")
	public String registProc(User user) {
		us.regist(user);
		return "redirect:/loginForm";
	}
	
	@GetMapping("/loginForm")
	public String loginForm(@RequestParam (value="error", required = false) String error, Model model) {
		if(error != null) {
			model.addAttribute("errormsg", "아이디나 비밀번호를 확인해 주십시오.");
		}
		return "loginForm";
	}
	
	@GetMapping("/logout")
	public String logout() {
		return "/main";
	}
	
}
