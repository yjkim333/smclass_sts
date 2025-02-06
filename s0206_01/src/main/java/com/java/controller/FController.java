package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.java.dto.MemberDto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class FController {
	
	@Autowired
	HttpSession session;
	
	@GetMapping("/")
	public String index() {
		System.out.println("index 페이지가 열립니다.");
		
		return "index";
	}
	
	@GetMapping("/login")
	public String login() {
		System.out.println("login get방식");
		return "login";
	}
	
	@PostMapping("/login")
	public String doLogin(HttpServletRequest request, Model model) {
		System.out.println("login post방식");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		
		session.setAttribute("session_id", id);
		
		return "logInfo";
	}
	
	@RequestMapping("/logout") // @GetMapping, @PostMapping 2개 모두 사용 => 권장X - 보안에 안좋음.
	public String logout() {
		System.out.println("logout 페이지가 열립니다.");
		session.invalidate();
		return "logout";
	}
	
	@GetMapping("/member")
	public String member() {
		return "member";
	}
	
	// 회원가입
	@PostMapping("/member")
	public ModelAndView member(HttpServletRequest request) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String gender = request.getParameter("gender");
		String[] hobbys = request.getParameterValues("hobby");
		String hobby = "";	// "게임,골프,수영"
		for (int i = 0; i < hobbys.length; i++) {
			if(i==0) hobby += hobbys[i];
			else hobby += ","+hobbys[i];
		}
		
		System.out.println("아이디 : "+id+"아이디 : "+id+"아이디 : "+id+"아이디 : "+id+"아이디 : "+id+"아이디 : "+id);
		
		// model 사용
		//model.addAttribute("id",id);
		//model.addAttribute("member",new MemberDto(id, pw, name, tel, gender, hobby));
		
		// ModelandView 사용
		ModelAndView mv = new ModelAndView();
		mv.setViewName("meminfo");
		mv.addObject("member", new MemberDto(id, pw, name, tel, gender, hobby));
		
		return mv;
	}
	
	// 회원정보
	@GetMapping("/meminfo")
	public String meminfo() {
		return "meminfo";
	}
	

	
	
	
	
}
