package com.java.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.BoardMapper;
import com.java.dto.BoardDto;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired BoardMapper boardMapper;
	
	@Override
	public void bwrite(BoardDto bdto) {
		boardMapper.insertBoard(bdto);
		
	}

	@Override
	public ArrayList<BoardDto> blist() {
		ArrayList<BoardDto> bdto = boardMapper.selectAll();
		return bdto;
	}

	@Override
	public BoardDto bview(int bno) {
		BoardDto bdto = boardMapper.selectOne(bno);
		return bdto;
	}

}
