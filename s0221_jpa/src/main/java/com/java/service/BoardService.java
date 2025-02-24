package com.java.service;

import java.util.List;

import com.java.dto.BoardDto;

public interface BoardService {

	// 게시글 전체리스트
	List<BoardDto> findAll();

	// 게시글 상세보기
	BoardDto findById(int bno);

}
