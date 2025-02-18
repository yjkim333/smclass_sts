package com.java.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.MemberBoardDto;

@Mapper
public interface MemberBoardMapper {

	// 주문 배송 조회
	ArrayList<MemberBoardDto> selectAll();

}
