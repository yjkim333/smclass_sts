package com.java.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.dto.BoardDto;
import com.java.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	BoardService boardService;

	// 게시판 전체리스트
	@GetMapping("/blist")
	public String blist(Model model) {
		ArrayList<BoardDto> list = boardService.blist();
		model.addAttribute("list", list);
		return "blist";
	}

	// 게시글 쓰기 페이지
	@GetMapping("/bwrite")
	public String bwrite() {
		return "bwrite";
	}

	// 게시글 쓰기 저장
	@PostMapping("/bwrite")
	public String bwrite(BoardDto bdto) {
		boardService.bwrite(bdto); // id,btitle,bcontent,file

		return "redirect:/board/blist?chkBwirte=1";
	}

	// 게시글 상세보기
	@GetMapping("/bview")
	public String bview(@RequestParam(defaultValue = "1") int bno, Model model) {
		// 1개 게시글 가져오기
		System.out.println("bno : " + bno);
		BoardDto boardDto = boardService.bview(bno);
		model.addAttribute("bdto", boardDto);
		return "bview";
	}

	// 게시글 삭제
	@GetMapping("/bdelete")
		public String bdelete(int bno) {
		System.out.println("bdelete bno : "+bno);
		boardService.bdelete(bno);
		return "redirect:/board/blist";
	}

}
