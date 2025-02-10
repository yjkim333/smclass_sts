package com.java.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.java.dto.BoardDto;
import com.java.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired BoardService boardService;
	
	// 게시판리스트
	@GetMapping("/board/blist")
	public String blist(Model model) {
		
		ArrayList<BoardDto> list = boardService.blist();
		model.addAttribute("list", list);
		
		return "blist";
	}
	
	// 게시글쓰기 페이지
	@GetMapping("/board/boardWrite")
	public String boardWrite() {
		return "boardWrite";
	}
	// 게시글쓰기 저장
	@PostMapping("/board/boardWrite")
	public String boardWrite(BoardDto bdto) {
		System.out.println("넘어온 제목 : "+bdto.getBtitle());
		boardService.boardWrite(bdto);
		return "boardWrite";
	}
	

}
