package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.dto.MemberDto;
import com.java.service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired HttpSession session;
	@Autowired MemberService memberService;
	
	@GetMapping("/login")
	public String login() {
		return "/member/login";
	}
	
	// 로그인체크
	@PostMapping("/login")
	public String login(MemberDto mdto, Model model) {
		System.out.println("id : "+ mdto.getId());
		System.out.println("pw : "+ mdto.getPw());
		
		MemberDto memberDto = memberService.login(mdto);
		
		if(memberDto != null) {
			session.setAttribute("session_id", memberDto.getId());
			return "redirect:/?loginChk=1";
		}else {
			model.addAttribute("loginChk", 0);
			return "/member/login";
		}
	}
	
	// 로그아웃
	@GetMapping("/logout")
	public String logout() {
		session.invalidate();
		return "redirect:/?loginChk=0";
	}
	
	
	
}
