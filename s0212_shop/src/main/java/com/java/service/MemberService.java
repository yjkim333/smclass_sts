package com.java.service;

import java.util.List;

import com.java.dto.MemberDto;

public interface MemberService {

	// 로그인체크
	MemberDto login(MemberDto mdto);

	// 인증이메일 발송 - text
	String sendEmail(String email);
	
	// 인증이메일 발송 - html
	String sendEmail2(String email);

	// 회원 전체 가져오기 (React)
	List<MemberDto> memberList();

	// 회원1명 가져오기 (React)
	MemberDto memberView(String id);

}
