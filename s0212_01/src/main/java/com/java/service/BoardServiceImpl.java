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

	// 게시글 저장
	@Override
	public void bwrite(BoardDto bdto) {
		boardMapper.insertBoard(bdto);
	}

	// 1개 게시글 상세보기
	@Override
	public BoardDto bview(int bno) {
		BoardDto bdto = boardMapper.selectOne(bno);
		return bdto;
	}

}
