package com.java.service;

import java.util.List;

import com.java.dto.MemberDto;

public interface MemberService {
	
	// 회원가입
	void save(MemberDto mdto);

	// 전체 회원리스트
	List<MemberDto> findAll();

	// 회원1명 상세정보
	MemberDto findById(String id);

	// 회원 삭제
	void deleteById(String id);

	// 로그인
	MemberDto findByIdAndPw(String id, String pw);

}
