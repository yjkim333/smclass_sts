package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dto.MemberDto;
import com.java.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired MemberRepository memberRepository;
	
	// 회원가입
	@Override
	public void save(MemberDto mdto) {
		memberRepository.save(mdto); // 자동으로 저장 => mapper.xml, spl 필요없음.
		
	}

	// 전체 회원리스트
	@Override
	public List<MemberDto> findAll() {
		List<MemberDto> list = memberRepository.findAll();
		return list;
	}

	
	// 회원1명 상세정보
	@Override
	public MemberDto findById(String id) {
		// findById -> 검색이 없을 경우 에러처리를 해야 함. =>.orElseThrow()
		// select * from memberdto where id=#id
		// findByIdAndPw => select * from memberdto where id=#id and pw=#{pw}
		MemberDto mdto = memberRepository.findById(id)
				.orElseThrow(()->{
					return new IllegalArgumentException("데이터처리시 에러 발생!!");
				});
		return mdto;
	}

	
	// 회원 삭제
	@Override
	public void deleteById(String id) {
		memberRepository.deleteById(id);
		
	}
	
	// 로그인
	@Override
	public MemberDto findByIdAndPw(String id, String pw) {
		MemberDto memberDto = memberRepository.findByIdAndPw(id,pw); 
		return memberDto;
	}
}
