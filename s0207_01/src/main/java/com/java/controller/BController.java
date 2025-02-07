package com.java.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.dto.BoardDto;
import com.java.service.BService;
import com.java.service.BServiceImpl;

@Controller
@RequestMapping("/board")
public class BController {
	
//	BService bservice = new BServiceImpl();
	@Autowired BService bService;
	
	@GetMapping("/blist") // url
	public String blist(Model model) {
		// 게시판리스트 - 게시글 여러 개가 존재
		// 게시글 1개만 가져오기 => BoardDto
		// 게시글 여러개 가져오기 => ArrayList<BoardDto>
		
		ArrayList<BoardDto> list = bService.blist(); 
		
		// jsp페이지에 보냄 -> Model
		model.addAttribute("list", list);
		
		return "/board/blist"; // 폴더위치
	}
	
}
