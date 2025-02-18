package com.java.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.dto.MemberBoardDto;
import com.java.service.MypageService;

@Controller
@RequestMapping("/mypage")
public class MypageController {
	
	@Autowired MypageService mypageService;
	
	// 주문 배송 조회
	@GetMapping("/ordercheck")
	public String getMethodName(Model model) {
		ArrayList<MemberBoardDto> list = mypageService.selectAll();
		model.addAttribute("list", list);
		
		System.out.println("controller name : "+list.get(0).getMemberDto().getName());
		System.out.println("controller phone : "+list.get(0).getMemberDto().getPhone());
		System.out.println("controller btitle : "+list.get(0).getBoardDto().getBtitle());
		System.out.println("controller bgroup : "+list.get(0).getBoardDto().getBgroup());
		
		return "/mypage/ordercheck";
	}
	
}
