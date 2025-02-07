package com.java.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.java.dto.BoardDto;

//@Repository // DB관련 => Dao

//Mybatis
@Mapper	
public interface BMapper {
	
	//게시판 리스트
	ArrayList<BoardDto> blist();

}
