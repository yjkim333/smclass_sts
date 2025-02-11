package com.java.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.BoardDto;

@Mapper
public interface BoardMapper {
	
	// 게시판 전체리스트 + 검색  = 시작번호,끝번호,카테고리,검색어
	ArrayList<BoardDto> selectAll(int startrow, int endrow, String category, String searchW);

	
	// === 페이지 하단 넘버링 ===
	// 게시글 총 개수 + 검색어 총 개수
	int countAll(String category, String searchW);

	
	// 게시글 쓰기 저장
	int insertBoard(BoardDto bdto);
	
	// ---- 게시글 상세보기 ---
	// 조회수 1증가
	void updateBhit(int bno);
	// 현재 게시글 상세보기
	BoardDto selectOne(int bno);
	// 이전 게시글 정보
	BoardDto selectOnePrev(int bno);
	// 다음 게시글 정보
	BoardDto selectOneNext(int bno);

	
	// 게시글 삭제
	void deleteBoard(int bno);
	
	// 게시글 수정 저장
	void updateBoard(BoardDto bdto);
	
	
	// ---- 답변달기 저장 ---
	// 자식게시글 bstep 1 증가
	void bstepUp(BoardDto bdto);
	// 답변달기 저장
	void insertBreply(BoardDto bdto);

	

}
