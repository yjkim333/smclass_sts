package com.java.dao;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.MemberDto;

@Mapper
public interface MemberMapper {
	
	// 로그인체크
	MemberDto selectLogin(String id, String pw);
	
	// 회원가입
	int insertMember(MemberDto mdto);

}
