package com.java.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.BoardDto;

@Mapper
public interface BoardMapper {
	
	// 게시판 전체리스트
	ArrayList<BoardDto> selectAll();
	
	// 게시글 저장
	void insertBoard(BoardDto bdto);
	
	// 1개 게시글 상세보기
	BoardDto selectOne(int bno);

}
