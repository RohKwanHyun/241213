package com.example.demo.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam")
public class ExamController {
	
	@GetMapping("/question1page")
	public String exam1page(Principal principal, Model model) {
	    if (principal != null) {
	        String username = principal.getName();
	        model.addAttribute("username", username);
	    }
		return "question1page";
	}

	@PostMapping("/question1")
	public String exam1(Principal principal, Model model) {
	    if (principal != null) {
	        String username = principal.getName();
	        model.addAttribute("username", username);
	    }
		return "question2";
	}

}
