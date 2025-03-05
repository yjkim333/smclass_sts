package com.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.dto.MemberDto;

//  extends JpaRepository<MemberDto, String> => <사용할 객체, pk 타입>
public interface MemberRepository extends JpaRepository<MemberDto, String>{

}
