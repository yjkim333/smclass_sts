package com.java.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.dto.MemberDto;
import com.java.service.MemberService;

import jakarta.servlet.http.HttpSession;


@Controller
public class MemberController {
	
	@Autowired MemberService memberService;
	@Autowired HttpSession session;
	
	// 회원가입 페이지
	@GetMapping("/member")
	public String member() {
		return "member";
	}
	
	// 회원가입 정보저장
	@PostMapping("/member")
	public String member(MemberDto mdto) {
		memberService.save(mdto);
		return "redirect:/";
	}
	
	// 전체 회원리스트
	@GetMapping("/mlist")
	public String mlist(Model model) {
		List<MemberDto> list = memberService.findAll();
		model.addAttribute("list", list);
		return "mlist";
	}
	
	// 회원1명 상세정보
	@GetMapping("/meminfo")
	public String meminfo(String id, Model model) {
		MemberDto mdto = memberService.findById(id);
		model.addAttribute("mdto", mdto);
		return "meminfo";
	}
	
	// 회원정보수정페이지
	@GetMapping("/memupdate")
	public String memupdate(String id, Model model) {
		MemberDto mdto = memberService.findById(id);
		model.addAttribute("mdto", mdto);
		return "memupdate";
	}
	
	// 회원정보수정 저장
	@PostMapping("/memupdate")
	public String memupdate(MemberDto mdto, Model model) {
		MemberDto memberDto = memberService.findById(mdto.getId());
		memberDto.setPhone(mdto.getPhone());
		memberDto.setGender(mdto.getGender());
		memberDto.setHobby(mdto.getHobby());
		memberDto.setMdate(memberDto.getMdate());
		memberService.save(mdto); // save() => id가 존재하면 update로 실행 / id가 존재하지 않으면 save로 실행
		return "redirect:/mlist";
	}
	
	// 회원 삭제
	@PostMapping("/memdelete")
	@ResponseBody // ajax으로 보냈기 때문에
	public String memdelete(String id, Model model) {
		System.out.println("id : "+id);
		memberService.deleteById(id);
		return "1";
	}
	
	
	// 로그인
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	// 로그인
	@PostMapping("/login")
	public String login(String id, String pw) {
		MemberDto mdto = memberService.findByIdAndPw(id,pw);
		if(mdto != null) {
			System.out.println("로그인 성공!");
			session.setAttribute("session_id", mdto.getId());
			return "redirect:/";
		}else {
			System.out.println("로그인 실패!");
		}
		return "redirect:/login?loginChk=0";
	}

}
