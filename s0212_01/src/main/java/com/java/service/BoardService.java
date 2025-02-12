package com.java.service;

import java.util.ArrayList;

import com.java.dto.BoardDto;

public interface BoardService {
	
	// 게시판 전체리스트
	ArrayList<BoardDto> blist();
	// 게시글 저장
	void bwrite(BoardDto bdto);
	// 1개 게시글 상세보기
	BoardDto bview(int bno);

}
