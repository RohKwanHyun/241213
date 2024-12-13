package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ExamController {
	
	@GetMapping("/exam1page")
	public String exam1page() {
		return "exam1page";
	}
	
	@PostMapping("/exam1")
	public String exam1(@RequestParam ("useranswer") String useranswer) {
		
		return "exam2";
	}

}
