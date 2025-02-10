package com.java.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.BoardDto;

@Mapper
public interface BoardMapper {
	
	// 게시판 전체리스트
	ArrayList<BoardDto> selectAll();
	
	// 게시글 쓰기 저장
	void insertBoard(BoardDto bdto);

}
