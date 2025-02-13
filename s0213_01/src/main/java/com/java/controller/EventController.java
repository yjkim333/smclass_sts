package com.java.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.dto.CboardDto;
import com.java.dto.EventDto;
import com.java.service.EventService;


@Controller
@RequestMapping("/event")
public class EventController {
	
	@Autowired EventService eventService;
	
	// 이벤트리스트 가져오기
	@GetMapping("/event")
	public String event(Model model) {
		ArrayList<EventDto> list = eventService.event_list(); 
		model.addAttribute("list", list);
		return "/event/event";
	}
	
	// 이벤트 상세보기
	@GetMapping("/event_view")
	public String event_view(int eno, Model model) {
		// 이벤트 상세 내용 가져오기
		EventDto eventDto = eventService.event(eno);
		// 전체 댓글 가져오기
		ArrayList<CboardDto> clist = eventService.clist(eno);
		
		model.addAttribute("edto", eventDto);
		model.addAttribute("clist", clist);
		return "/event/event_view";
	}
	
	
	

}
