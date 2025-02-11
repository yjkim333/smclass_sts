package com.java.controller;

import java.util.ArrayList;
import java.util.Map;

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

	// 게시판 전체리스트 + 게시글 검색
	@GetMapping("/blist")
	public String blist(@RequestParam(value = "page", defaultValue = "1") int page, String category, String searchW, Model model) {
		// 전체리스트 출력 - 페이지, 카테고리, 검색어
		Map<String, Object> map = boardService.blist(page,category,searchW);
		model.addAttribute("list", map.get("list"));
		model.addAttribute("page", map.get("page"));
		model.addAttribute("startpage", map.get("startpage"));
		model.addAttribute("endpage", map.get("endpage"));
		model.addAttribute("maxpage", map.get("maxpage"));
		model.addAttribute("category", map.get("category"));
		model.addAttribute("searchW", map.get("searchW"));
		System.out.println("category : "+category);
		System.out.println("searchW : "+searchW);
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
	public String bview(@RequestParam(defaultValue = "1") int bno,int page, Model model) {
		// 1개 게시글 가져오기
		System.out.println("bno : " + bno);
		Map<String, Object> map = boardService.bview(bno);
		model.addAttribute("bdto", map.get("boardDto"));
		model.addAttribute("pdto", map.get("prevDto"));
		model.addAttribute("ndto", map.get("nextDto"));
		model.addAttribute("currpage", page); // 페이지넘버
		return "bview";
	}

	// 게시글 삭제
	@GetMapping("/bdelete")
		public String bdelete(int bno) {
		System.out.println("bdelete bno : "+bno);
		boardService.bdelete(bno);
		return "redirect:/board/blist";
	}
	
	// 게시글 수정 페이지
	@GetMapping("/bupdate")
	public String bupdate(int bno, int page, Model model) {
		System.out.println("bupdate bno : "+bno);
		BoardDto boardDto = boardService.bupdate(bno);
		model.addAttribute("bdto", boardDto);
		model.addAttribute("currpage", page); // 페이지넘버
		return "bupdate";
	}
	
	// 게시글 수정 저장
	@PostMapping("/bupdate")
	public String bupdate(BoardDto bdto,int page,Model model) {
		System.out.println("bupdate bno : "+bdto.getBno());
		boardService.bupdate(bdto);
		model.addAttribute("currpage", page); // 페이지넘버
		return "redirect:/board/blist?page="+page;
	}
	
	// 게시글 답변달기 페이지
	@GetMapping("/breply")
	public String breply(int bno, int page, Model model) {
		System.out.println("breply bno : "+bno);
		BoardDto boardDto = boardService.breply(bno);
		model.addAttribute("bdto", boardDto);
		return "breply";
	}
	
	// 게시글 답변달기 저장
	@PostMapping("/breply")
	public String breply(BoardDto bdto, int page, Model model) {
		System.out.println("breply bno : "+bdto.getBno());
		boardService.breply(bdto);
		model.addAttribute("currpage", page); // 페이지넘버
		return "redirect:/board/blist/blist?page="+page;
	}

}
