package com.java.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.BoardDto;

@Mapper // resources/mapper/ ~~.xml 연결 // xml에는 sql쿼리문이 있음
public interface BoardMapper {


	ArrayList<BoardDto> blist();
	
	
	

}
