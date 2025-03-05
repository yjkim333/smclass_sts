package com.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.dto.MemberDto;
import com.java.service.MemberService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired HttpSession session;
	@Autowired MemberService memberService;
	
	// 회원 전체 가져오기 (React)
	@CrossOrigin
	@ResponseBody
	@GetMapping("/memberList")
	public List<MemberDto> memberList() {
		List<MemberDto> list = memberService.memberList();
		return list;
	}
	
	// 회원1명 가져오기 (React) 자바스크립트에서 json 데이터 가져오기 => @RequestBody 붙여야함
	@CrossOrigin
	@ResponseBody
	@GetMapping("/memberView")
	//@RequestBody => json 데이터로 전달받으면 붙여야함.
	public MemberDto memberView(String id) {
		System.out.println("memberView id : "+id);
		MemberDto mdto = memberService.memberView(id);
		return mdto;
	}
	
	
	// 로그인 페이지
	@GetMapping("/login")
	public String login(HttpServletResponse response) {
		// JAVA - 쿠키 생성
		//Cookie cookie = new Cookie("cook_id", "aaa");
		//cookie.setMaxAge(60*60*24); // 60*60*24 = 1일
		//response.addCookie(cookie); // 쿠키저장
		
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
	
	// 회원가입
	@GetMapping("/step01")
	public String step01() {
		return "/member/step01";
	}
	
	// 인증이메일 발송
	@ResponseBody
	@PostMapping("/sendEmail")
	public String sendEmail(String email) {
		System.out.println("sendEmail : "+email);
		String pwcode = memberService.sendEmail(email); // text로만 발송
		//String pwcode = memberService.sendEmail2(email);	// html 발송
		return pwcode;
	}
	
	// 인증이메일 발송2
	@ResponseBody
	@PostMapping("/sendEmail2")
	public String sendEmail2(String email) {
		System.out.println("sendEmail2 : "+email);
		//String pwcode = memberService.sendEmail(email); // text로만 발송
		String pwcode = memberService.sendEmail2(email);	// html 발송
		session.setAttribute("pwcode", pwcode);
		
		return pwcode;
	}
	
	
	// 인증코드 체크
	@ResponseBody
	@PostMapping("/pwcodeCheck")
	public String pwcodeCheck(String pwcode) {
		System.out.println("pwcode : "+pwcode);
		String pw = (String) session.getAttribute("pwcode");
		if(pwcode.equals(pw)) {
			return "1";
		}else {
			return "0";
		}
	}
	
	// 회원가입 step02 페이지
	@GetMapping("/step02")
	public String login() {
		session.removeAttribute("pwcode"); // pwcode 세션 삭제
		return "/member/step02";
	}
}
