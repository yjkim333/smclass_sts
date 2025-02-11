package com.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.dao.MemberMapper;
import com.java.dto.MemberDto;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {
	
	@Autowired MemberMapper memberMapper;
	
	// 로그인 확인
	@Override
	public MemberDto login(MemberDto mdto) {
		MemberDto memberDto = memberMapper.loginChk(mdto);
		
		return memberDto;
	}

}
