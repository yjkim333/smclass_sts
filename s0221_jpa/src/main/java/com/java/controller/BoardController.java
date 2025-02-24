package com.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.java.dto.BoardDto;
import com.java.service.BoardService;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class BoardController {
	
	@Autowired BoardService boardService;
	
	// 게시글 전체리스트
	@GetMapping("/blist")
	public String blist(Model model) {
		List<BoardDto> list = boardService.findAll();
		model.addAttribute("list", list);
		return "blist";
	}
	
	// 게시글 상세보기
	@GetMapping("/bview")
	public String bview(int bno, Model model) {
		
		BoardDto bdto = boardService.findById(bno);
		model.addAttribute("bdto", bdto);
		
		return "bview";
	}
	
	 
	
}
