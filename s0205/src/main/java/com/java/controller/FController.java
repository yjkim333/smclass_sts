package com.java.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller // 프로그램실행시 바로 실행 => url 모든 링크는 controller 로 분기
public class FController {
	
	@Autowired
	HttpSession session;
	
	@GetMapping("/") //
	public String index() {
		return "index";
	}
	
	@GetMapping("/login") //
	public String login() {
		System.out.println("get 방식으로 들어옴");
		return "login";
	}
	
	@PostMapping("/doLogin")
	public String doLogin(HttpServletRequest request) {
		System.out.println("post 방식으로 들어옴");
		// HttpSession session = request.getSession();
		session.setAttribute("session_id", "aaa"); // 세션 추가
		return "index";
	}
	
	@GetMapping("/logout") //
	public String logout() {
		session.invalidate(); // 세션 삭제
		return "logout";
	}
	
	
}
