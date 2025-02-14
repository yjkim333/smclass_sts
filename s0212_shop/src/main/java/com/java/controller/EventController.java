package com.java.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.dto.CboardDto;
import com.java.dto.EventDto;
import com.java.service.EventService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/event")
public class EventController {
	
	@Autowired HttpSession session;
	@Autowired EventService eventService;
	
	// 이벤트 리스트
	@GetMapping("/event")
	public String event(Model model) {
		// 전체리스트 가져오기
		ArrayList<EventDto> list = eventService.event();
		model.addAttribute("list", list);
		
		return "/event/event";
	}
	
	// 이벤트 상세보기
	@GetMapping("/eview")
	public String eview(int eno, Model model) {
		// 이벤트 1개 가져오기
		EventDto eventDto = eventService.eview(eno);
		// 하단댓글 가져오기
		ArrayList<CboardDto> clist = eventService.clist(eno);
		
		model.addAttribute("edto", eventDto);
		model.addAttribute("clist", clist);
		
		return "/event/eview";
	}
	
	// 댓글 비번체크
	@GetMapping("/pwCboard")
	public String getMethodName(int cno) {
		return "/event/pwCboard";
	}
	// 댓글 비번체크
	@PostMapping("/pwCboard")
	public String getMethodName(int cno,String cpw) {
		
		
		return "/event/pwCboard";
	}
	
	
}
