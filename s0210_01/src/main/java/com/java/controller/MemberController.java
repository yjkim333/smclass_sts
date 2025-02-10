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
public class MemberController {
	
	@Autowired MemberService memberService;	
	@Autowired HttpSession session;
	
	// 로그인페이지
	@GetMapping("/member/login")
	public String login() {
		return "login";
	}
	
	// 로그인체크
	@PostMapping("/member/login")
	public String login(String id, String pw, Model model) {
		
		MemberDto memberDto = memberService.login(id,pw);
		if(memberDto != null) { // 로그인 성공
			model.addAttribute("chkLogin", "1");
			session.setAttribute("session_id", id); // session 추가
			session.setAttribute("session_name", memberDto.getName());
		}
		else {
			model.addAttribute("chkLogin", "0"); // 로그인 실패
		}
		return "login";
	}

	// 로그아웃
	@GetMapping("/member/logout")
	public String logout(Model model) {
		session.invalidate();
		model.addAttribute("chkLogin", "0");
		return "logout";
	}
	
	// 회원가입
	@GetMapping("/member/member")
	public String member(Model model) {
		return "member";
	}
	
	// 회원가입 저장
	@PostMapping("/member/member")
	public String member(MemberDto mdto, Model model) {
		memberService.member(mdto);
		return "redirect:/";
	}

}
