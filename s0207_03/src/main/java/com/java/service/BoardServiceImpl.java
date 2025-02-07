package com.java.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.BoardMapper;
import com.java.dto.BoardDto;

@Service
public class BoardServiceImpl implements BoardService{

	
	@Autowired BoardMapper boardMapper;
	
	@Override
	public ArrayList<BoardDto> blist() {
		System.out.println("BoardServiceImpl ------ ok");
		ArrayList<BoardDto> list = boardMapper.boardSelect();
		
		list = boardMapper.boardSelect();
		
		return list;
	}

}
