package com.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.java.dto.MemberDto;
public interface MemberRepository extends JpaRepository<MemberDto, String>{
// extends JpaRepository<MemberDto, String>
// => 자동으로 @Repository 생성
// JpaRepository<리턴타입(Dto객체), pk 타입>
	
	
	// 로그인
	MemberDto findByIdAndPw(String id, String pw);
	// select * from member where id=#{id} and pw=#{pw}
	
	// nativeQuery사용
	//@Query(value = "select * from memberdto where id=? and pw=?", nativeQuery = true)
	//Optional<MemberDto> findByIdandPw(String id, String pw);
	//MemberDto findByIdAndPw(String id, String pw);
	
	
}
