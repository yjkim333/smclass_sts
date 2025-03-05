package com.java.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
		List<EventDto> list = eventService.findAll();
		model.addAttribute("list", list);
		
		return "/event/event";
	}
	
	// 이벤트 상세보기
	@GetMapping("/eview")
	public String eview(int eno, Model model) {
		System.out.println(eno);

		// 이벤트 1개 가져오기 상세보기
		EventDto eventDto = eventService.findByEno(eno);
		// 하단댓글 가져오기
		//ArrayList<CboardDto> clist = eventService.clist(eno);
		model.addAttribute("edto", eventDto);
		model.addAttribute("clist", eventDto.getClist());// 이렇게 넘기면 무한루프 생길수 있음. eventdto에 무한루프방지 넣으셈.
		
		return "/event/eview";
	}
	
	// 이벤트 글 쓰기 페이지 오픈
	@GetMapping("/eventWrite")
	public String eview() {
		
		return "/event/eventWrite";
	}
	// 이벤트 글 쓰기저장
	@PostMapping("/eventWrite")
	public String eview(EventDto edto,
			//파일 1개 받을때 @RequestPart MultipartFile files,
			@RequestPart List<MultipartFile> files
			) throws Exception {
		
		// 파일저장 위치 설정
		String url = "c:/upload/event/";
		String fileName = "";
		for (int i = 0; i < files.size(); i++) {
			String originName = files.get(i).getOriginalFilename();
			long time = System.currentTimeMillis();
			String uploadFileName = String.format("%d+_%s",time,originName);
			File f = new File(url+uploadFileName);
			files.get(i).transferTo(f); // 파일 업로드 => trycatch
			if(i==0) edto.setEfile(uploadFileName);
			else edto.setEfile2(uploadFileName);
		}
		//edto.getMemberDto().getId();
		
		//System.out.println("edto id : "+edto.getMemberDto().getId());
		System.out.println("edto etitle : "+edto.getEtitle());
		System.out.println("edto efile : "+edto.getEfile());
		System.out.println("edto efile2 : "+edto.getEfile2());
		
		//db 저장
		eventService.eventSave(edto);
		
		return "/event/eventWrite";
		//return "redirect:/event/event";
	}
	
	
		
	
}
