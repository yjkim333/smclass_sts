package com.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.data.web.SortDefault.SortDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.java.dto.BoardDto;
import com.java.service.BoardService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class BoardController {
	
	@Autowired BoardService boardService;
	
	// 게시글 전체리스트
	// 페이지 넘버링 - Pageable -> 자동 계산해서 가져옴
	// page를 파라미터값으로 받아야함.
	@GetMapping("/blist")
	//@ResponseBody // 데이터로 리턴하겠다.
	public String blist(
			@PageableDefault(page = 0,size = 10) // 1페이지, 1페이지당 10개
			@SortDefaults(
					{@SortDefault(sort="bgroup",direction = Sort.Direction.DESC), @SortDefault(sort="bstep",direction = Sort.Direction.ASC)}
					) Pageable pageable ,Model model) {
		// List 타입이 아닌 Page 객체
		Page<BoardDto> page = boardService.findAll(pageable);
		
		List<BoardDto> list = page.getContent();
		
		// - 하단 넘버링 -
		// page 정보 정리해서 model 로 보냄
		// page -> 0에서 시작
		int nowpage = page.getPageable().getPageNumber()+1;
		int maxpage = page.getTotalPages();
		int startpage = ((nowpage-1)/10)*10+1; // 페이지 범위의 시작페이지 (1-10의1,11-20의11)
		int endpage = startpage+10-1;
		//if(endpage>maxpage) {
		//	endpage = maxpage;
		//}
		endpage = Math.min(maxpage,endpage);
		
		// 출력해보기
		System.out.println("현재페이지 :"+nowpage);
		System.out.println("maxpage :"+maxpage);
		System.out.println("startpage :"+startpage);
		System.out.println("endpage :"+endpage);
		
		model.addAttribute("nowpage", nowpage);
		model.addAttribute("maxpage", maxpage);
		model.addAttribute("startpage", startpage);
		model.addAttribute("endpage", endpage);
		model.addAttribute("list", list);
		return "blist";
//		return page;
	}
	
	// 게시글 상세보기
	@GetMapping("/bview")
	public String bview(int bno, Model model) {
		
		BoardDto bdto = boardService.findById(bno);
		model.addAttribute("bdto", bdto);
		
		return "bview";
	}
	
	
	// 게시글 검색
	@GetMapping("/bsearch")
	public String bsearch(String search, Model model) {
		
		// 1. select * from boarddto where btitle='dd'
		//List<BoardDto> list = boardService.findByBtitle(search);
		
		// 2. select * from boarddto where btitle like '%dd%'
		List<BoardDto> list = boardService.findByBtitleContaining(search);
		System.out.println("Controller -- search : "+search);
		model.addAttribute("list", list);
		return "blist";
	}
	
	 
	
}
