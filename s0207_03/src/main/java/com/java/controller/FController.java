package com.java.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.java.dto.BoardDto;
import com.java.dto.MemberDto;
import com.java.service.BoardService;
import com.java.service.MemberService;

@Controller
public class FController {
	
	@Autowired BoardService boardService;
	@Autowired MemberService memberService;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	
	@GetMapping("/board/blist")
	public String blist(Model model) {
		System.out.println("controller --------- ok");
		
		ArrayList<BoardDto> list = boardService.blist();
		model.addAttribute("list", list);
		
		return "blist";
	}
	
	@GetMapping("/member/mlist")
	public String mlist(Model model) {
		System.out.println("controller --------- ok");
		
		ArrayList<MemberDto> list = memberService.mlist();
		model.addAttribute("list", list);
		
		return "mlist";
	}
	
	
}
