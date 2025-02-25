package com.java.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.java.dto.BoardDto;

// @Repository
public interface BoardRepository extends JpaRepository<BoardDto, Integer>{

	// 게시글 검색
	List<BoardDto> findByBtitleContaining(String search);
	// select * from boarddto where btitle like '%search%'
//	@Query(value = "select * from boarddto where btitle like %:search%", nativeQuery = true)
//	List<BoardDto> findByBtitleOrBcontentContaining(String search);
//	@Query(value = "select * from boarddto where btitle like %:search% or bcontent like %:search%", nativeQuery = true)
	
	
	
//	@Query(value = "select * from boarddto order by bgroup desc, bstep asc", nativeQuery = true)
//	List<BoardDto> findAll();
//	Page<BoardDto> findAll(pageable);
	
	
//	@Query(value = "select * from memberdto where id=? and pw=?", nativeQuery = true)
//	Optional<MemberDto> findByIdandPw(String id, String pw);

}
