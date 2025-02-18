package com.java.service;

import java.util.ArrayList;

import com.java.dto.MemberBoardDto;

public interface MypageService {

	// 주문 배송 조회
	ArrayList<MemberBoardDto> selectAll();

}
