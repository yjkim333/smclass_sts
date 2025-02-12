package com.java.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.dto.BoardDto;
import com.java.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired CustomerService customerService;
	
	// notice list
	@GetMapping("/notice")
	public String notice(String search_option, String search_word, Model model) {
		
		Map<String, Object> map = customerService.notice(search_option,search_word);
		
		//현재날짜 - new 뱃지 비교하기 위해.
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String today = sdf.format(d);
		
		//ArrayList<BoardDto> list = customerService.notice();
		model.addAttribute("list", map.get("list"));
		model.addAttribute("today", today);
		
		System.out.println("현재 날짜 : "+today);
		return "/customer/notice";
	}
	
	// nview
	@GetMapping("/nview")
	public String nview(int bno,Model model) {
		Map<String, Object> map = customerService.nview(bno);
		// 게시글 1개
		model.addAttribute("bdto", map.get("bdto"));
		// 이전글 
		model.addAttribute("prev_bdto", map.get("prev_bdto"));
		// 다음글
		model.addAttribute("next_bdto", map.get("next_bdto"));
		
		return "/customer/nview";
	}

}
