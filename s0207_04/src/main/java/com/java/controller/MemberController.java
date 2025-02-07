package com.java.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.dto.MemberDto;
import com.java.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired MemberService memberService;
	
	//회원리스트
	@GetMapping("/mlist")
	public String mlist(Model model) {
		//service 연결
		ArrayList<MemberDto> list = memberService.mlist();
		model.addAttribute("list", list);
		return "/member/mlist";
	}
}
