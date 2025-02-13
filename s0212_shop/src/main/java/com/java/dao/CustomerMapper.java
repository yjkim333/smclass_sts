package com.java.dao;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.BoardDto;

@Mapper
public interface CustomerMapper {
	
	// notice list + search
	Map<String, Object> selectAll(String search_option, String search_word);

	// nview
	// 1개 게시글 가져오기
	BoardDto selectOne(int bno);
	// 이전 게시글 가져오기
	BoardDto selectPrev(int bno);
	// 다음 게시글 가져오기
	BoardDto selectNext(int bno);

}
