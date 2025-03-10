package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.java.dto.BoardDto;
import com.java.repository.BoardRepository;

import jakarta.transaction.Transactional;

@Transactional // 
@Service
public class BoardServiceImpl implements BoardService {

	@Autowired BoardRepository boardRepository;
	
	// 게시글 전체리스트
	@Override
	public Page<BoardDto> findAll(Pageable pageable) {
		// 정렬 - 다중정렬
//		Sort sort = Sort.by(Sort.Order.desc("bgroup"),Sort.Order.asc("bstep"));
//		List<BoardDto> list = boardRepository.findAll(sort);
		
		// nativeQuery 사용 => BoardRepository 에서 재정의 sql 쿼리문 사용
		Page<BoardDto> list = boardRepository.findAll(pageable);
		return list;
	}

	// 게시글 1개 상세보기
	@Override
	public BoardDto findById(int bno) {
		BoardDto bdto = boardRepository.findById(bno).orElseThrow(
				()->{ // 람다식
					return new IllegalArgumentException("데이터 처리 에러!");
				});
		// jpa 영속성콘텐트 <=> DB
		// 조회수 1증가
		bdto.setBhit(bdto.getBhit()+1);
		// boardRepository.save(bdto); //@Transactional 이 있으면 리턴시에 save 자동으로 함.
		
		return bdto;
	}

	// 게시글 검색
	@Override
	public List<BoardDto> findByBtitleContaining(String search) {
		List<BoardDto> list = boardRepository.findByBtitleContaining(search);
		return list;
	}

}
