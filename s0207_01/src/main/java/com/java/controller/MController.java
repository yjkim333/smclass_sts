package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("/member")
public class MController {
	
	@Autowired HttpSession session; // session 객체
	
	//login
	@GetMapping("/login")
	//@RequestMapping(method=RequestMethod.GET, value = "/member/login")
	public String login() {
		return "/member/login"; // /member/login.jsp
	}
	
	//login
	@PostMapping("/login")
	public String login(String id, String pw) {
		// DB접근해서 id pw 맞는지 확인
		
		if(id.equals("aaa") && pw.equals("1111")) {
			session.setAttribute("session_id", id);
			return "redirect:/?chk=1"; // redirect 해서 "/" 로 가라 => redirect 는 model 못 넘김 
		} else {
			return "redirect:/member/login?chk=0";
		}
	}
	
	//logout
	@GetMapping("/logout")
	public String logout() {
		session.invalidate(); // session 모두 삭제
		return "redirect:/?outChk=1";
	}

}
