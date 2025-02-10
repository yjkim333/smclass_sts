package com.java.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.BoardDto;

@Mapper
public interface BoardMapper {
	
	// 게시판 전체리스트
	ArrayList<BoardDto> selectAll();
	
	// 게시글 쓰기 저장
	int insertBoard(BoardDto bdto);
	
	// 1개 게시글 상세보기
	BoardDto selectOne(int bno);
	
	// 조회수 1증가
	void updateBhit(int bno);
	
	// 게시글 삭제
	void deleteBoard(int bno);

}
