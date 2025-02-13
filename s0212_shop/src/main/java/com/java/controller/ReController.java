package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.dto.CboardDto;
import com.java.service.EventService;

import jakarta.servlet.http.HttpSession;

@RestController
public class ReController {
	
	@Autowired EventService eventService;
	@Autowired HttpSession session;
	
	// 댓글 저장
	@PostMapping("/event/cwrite")
	public CboardDto cwrite(CboardDto cdto) {
		//String id = (String) session.getAttribute("session_id");
		cdto.setId("aaa"); // 임의 설정
		// 댓글저장
		CboardDto cboardDto = eventService.cwrite(cdto);
		
		System.out.println("geteno : "+cdto.getEno());
		System.out.println("getCpw : "+cdto.getCpw());
		System.out.println("getCcontent : "+cdto.getCcontent());
		return cboardDto; // 데이터 전달함, 페이지 오픈하는 것이 아님.
	}
	
}
