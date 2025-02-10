package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.java.dto.MemberDto;
import com.java.service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
public class FController {
	
	@Autowired MemberService memberService;
	@Autowired HttpSession session;
	
	// index
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	//login
	@GetMapping("/member/login")
	public String login() {
		return "login";
	}
	
	//login check
	@PostMapping("/member/login")
	public String login(MemberDto mdto,Model model) {
		MemberDto memberDto = memberService.login(mdto);
		if(memberDto == null) {
			model.addAttribute("loginChk", "0");
		}else {
			session.setAttribute("session_id", mdto.getId());
			session.setAttribute("session_name", memberDto.getName());
			model.addAttribute("loginChk", "1");
		}
		return "login";
	}
	
	
	
	
}
