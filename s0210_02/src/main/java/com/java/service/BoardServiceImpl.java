package com.java.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.dao.BoardMapper;
import com.java.dto.BoardDto;

@Transactional // 함수진행이 끝난 후 commit! 중간에 에러가 나면 rollback.
@Service
public class BoardServiceImpl implements BoardService {

	@Autowired BoardMapper boardMapper;
	int rowPerPage = 5; // 한 페이지당 게시글 수
	
	// 게시판 전체리스트 + 검색
	@Override
	public Map<String, Object> blist(int page, String category, String searchW) {
		
		// 게시글 전체 개수 + 검색어 전체개수
		int count = boardMapper.countAll(category,searchW);
		
		// === 페이지 하단 넘버링 ===
		// 게시글 총 개수
		// int maxpage = boardMapper.countAll();
		// 마지막 페이지 넘버
		int maxpage = (int) Math.ceil((double)count/rowPerPage);
		// 첫번째 페이지 넘버 (1-10 의 1 , 11-20 의 11)
		int startpage = (int) ((page-1)/10)*10+1;
		// 마지막 페이지 넘버	 (1-10 의 10 , 11-20 의 20)
		int endpage = startpage+10-1;
		if(endpage>maxpage) endpage = maxpage; //(1-7 의 7)
		// 요청 페이지별 게시글 번호
		int startrow = (page-1)*rowPerPage+1;  		// 3페이지 열기-> (3-1)*10+1 => 31
		int endrow = startrow+rowPerPage-1; // 3페이지 열기-> 31+10-1 => 40
		
		// 전체리스트 - 시작번호, 끝번호, 카테고리, 검색어
		ArrayList<BoardDto> list = boardMapper.selectAll(startrow,endrow,category,searchW);
		
		// return type => map
		Map<String, Object> map = new HashMap<>();
		map.put("page", page);
		map.put("maxpage", maxpage);
		map.put("startpage", startpage);
		map.put("endpage", endpage);
		map.put("list", list);
		map.put("category", category);
		map.put("searchW", searchW);
		
		return map;
	}
		
	// 게시글 쓰기 저장
	@Override
	public void bwrite(BoardDto bdto) {
		int result = boardMapper.insertBoard(bdto);
		System.out.println("BoardServiceImpl 결과값 : "+result);
	}

	// 1개 게시글 상세보기
	@Override
	public Map<String, Object> bview(int bno) {
		Map<String, Object> map = new HashMap<>();
		// 조회수 1 증가 - update
		boardMapper.updateBhit(bno);
		
		// 현재 게시글 상세보기
		BoardDto boardDto = boardMapper.selectOne(bno);
		
		// 다음 게시글 정보
		BoardDto nextDto = boardMapper.selectOneNext(bno);
		
		// 이전 게시글 정보
		BoardDto prevDto = boardMapper.selectOnePrev(bno);
		//System.out.println("이전글 정보 : "+prevDto.getBno());
		//System.out.println("이전글 정보 : "+prevDto.getBtitle());
		
		map.put("boardDto", boardDto);
		map.put("prevDto", prevDto);
		map.put("nextDto", nextDto);
		
		return map;
	}
	
	// 게시글 1개 삭제
	@Override
	public void bdelete(int bno) {
		boardMapper.deleteBoard(bno);
	}

	// 게시글 수정 페이지
	@Override
	public BoardDto bupdate(int bno) {
		BoardDto boardDto = boardMapper.selectOne(bno);
		return boardDto;
	}
	
	// 게시글 수정 저장
	@Override
	public void bupdate(BoardDto bdto) {
		boardMapper.updateBoard(bdto);
	}
	
	// 게시글 답변달기 페이지
	@Override
	public BoardDto breply(int bno) {
		BoardDto boardDto = boardMapper.selectOne(bno);
		return boardDto;
	}

	// 게시글 답변달기 저장
	@Override
	public void breply(BoardDto bdto) {
		// 같은 bgroup의 부모게시글 보다 bstep이 높은 게시글 모두 bstep+1 (게시글 순서)
		boardMapper.bstepUp(bdto);
		// 답변달기 저장		
		boardMapper.insertBreply(bdto);
	}
	
	
}
