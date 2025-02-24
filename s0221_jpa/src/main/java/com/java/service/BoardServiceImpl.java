package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.java.dto.BoardDto;
import com.java.repository.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired BoardRepository boardRepository;
	
	// 게시글 전체리스트
	@Override
	public List<BoardDto> findAll() {
		// 정렬 - 다중정렬
//		Sort sort = Sort.by(Sort.Order.desc("bgroup"),Sort.Order.asc("bstep"));
//		List<BoardDto> list = boardRepository.findAll(sort);
		
		// nativeQuery 사용 => BoardRepository 에서 재정의 sql 쿼리문 사용
		List<BoardDto> list = boardRepository.findAll();
		return list;
	}

	// 게시글 상세보기
	@Override
	public BoardDto findById(int bno) {
		BoardDto bdto = boardRepository.findById(bno).orElseThrow(
				()->{ // 람다식
					return new IllegalArgumentException("데이터 처리 에러!");
				});
		return bdto;
	}

}
