package com.java.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.MemberBoardMapper;
import com.java.dto.MemberBoardDto;

@Service
public class MypageServiceImpl implements MypageService {
	
	@Autowired MemberBoardMapper memberBoardMapper;

	// 주문 배송 조회
	@Override
	public ArrayList<MemberBoardDto> selectAll() {
		ArrayList<MemberBoardDto> list = memberBoardMapper.selectAll();
		
		return list;
	}

	
	
	
}
