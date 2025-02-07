package com.java.service;

import java.util.ArrayList;

import com.java.dto.BoardDto;

public interface BoardService {
	
	//게시판리스트
	ArrayList<BoardDto> blist();
	
	//게시글 1개
	BoardDto bview(int bno);

}
