package com.java.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.MemberDto;

@Mapper
public interface MemberMapper {
	
	// 로그인체크
	MemberDto selectLogin(MemberDto mdto);

	// 회원 전체 가져오기 (React)
	List<MemberDto> selectAll();

	// 회원 1명 가져오기 (React)
	MemberDto selectOne();

}
