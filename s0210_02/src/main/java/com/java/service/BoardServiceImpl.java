package com.java.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.BoardMapper;
import com.java.dto.BoardDto;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired BoardMapper boardMapper;
	
	// 게시판 전체리스트
	@Override
	public ArrayList<BoardDto> blist() {
		ArrayList<BoardDto> list = boardMapper.selectAll();
		return list;
	}
		
	// 게시글 쓰기 저장
	@Override
	public void bwrite(BoardDto bdto) {
		int result = boardMapper.insertBoard(bdto);
		System.out.println("BoardServiceImpl 결과값 : "+result);
	}

	// 1개 게시글 상세보기
	@Override
	public BoardDto bview(int bno) {
		// 조회수 1 증가 - update
		boardMapper.updateBhit(bno);
		BoardDto boardDto = boardMapper.selectOne(bno);
		
		return boardDto;
	}
	
	// 게시글 1개 삭제
	@Override
	public void bdelete(int bno) {
		boardMapper.deleteBoard(bno);
	}
	
}
