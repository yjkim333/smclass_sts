package com.java.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.java.dto.BoardDto;

// @Repository
public interface BoardRepository extends JpaRepository<BoardDto, Integer>{
	
	@Query(value = "select * from boarddto order by bgroup desc, bstep asc", nativeQuery = true)
	List<BoardDto> findAll();
	
//	@Query(value = "select * from memberdto where id=? and pw=?", nativeQuery = true)
//	Optional<MemberDto> findByIdandPw(String id, String pw);

}
