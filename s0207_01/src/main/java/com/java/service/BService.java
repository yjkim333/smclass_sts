package com.java.service;

import java.util.ArrayList;

import com.java.dto.BoardDto;

public interface BService {
	
	// 게시글 리스트 가져오기
	ArrayList<BoardDto> blist();

}
