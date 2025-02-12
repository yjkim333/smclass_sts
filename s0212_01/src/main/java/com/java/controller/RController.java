package com.java.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.dto.BoardDto;
import com.java.service.BoardService;

@RestController
public class RController {
	
	//@RestController => 데이터를 달라고 하는 것
	
	@Autowired BoardService boardService;
	
	@GetMapping("/restpage")
	public ArrayList<BoardDto> restpage() {
		// int[] arr = {1,2,3,4,5};
		
		ArrayList<BoardDto> list = boardService.blist();
		// react => /restpage (데이터) 호출
		
		return list;
	}
	
}
