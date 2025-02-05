package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class FController {
	
	@Autowired
	HttpSession session;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/doLogin")
	public String doLogin(HttpServletRequest request) {
		String id = request.getParameter("id");
		session.setAttribute("session_id", id);
		return "index";
	}
	
	@GetMapping("logout")
	public String logout() {
		session.invalidate();
		return "index";
	}
	
	
	
}
