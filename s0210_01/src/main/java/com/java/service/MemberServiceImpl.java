package com.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.MemberMapper;
import com.java.dto.MemberDto;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired MemberMapper memberMapper;
	
	// 로그인체크
	@Override
	public MemberDto login(String id, String pw) {
		//Dao(Mapper)로 보내기
		MemberDto memberDto = memberMapper.selectLogin(id,pw);
		
		return memberDto;
	}

	// 회원가입
	@Override
	public void member(MemberDto mdto) {
		int result = memberMapper.insertMember(mdto);
		System.out.println("결과 : "+result);
	}

	

}
