package com.java.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.dao.EventMapper;
import com.java.dto.CboardDto;
import com.java.dto.EventDto;

@Service
@Transactional
public class EventServiceImpl implements EventService {

	@Autowired EventMapper eventMapper;
	
	// 이벤트 리스트
	@Override
	public ArrayList<EventDto> event() {
		ArrayList<EventDto> list = eventMapper.selectAll();
		return list;
	}

	// 이벤트 상세보기
	@Override
	public EventDto eview(int eno) {
		EventDto eventDto = eventMapper.selectOne(eno);
		return eventDto;
	}

	// 하단댓글 가져오기
	@Override
	public ArrayList clist(int eno) {
		ArrayList<CboardDto> clist = eventMapper.selectAllCboard(eno);
		return clist;
	}

	// 댓글 저장
	@Override
	public CboardDto cwrite(CboardDto cdto) {
		eventMapper.insertCboard(cdto);
		CboardDto cboardDto = eventMapper.selectOneCboard(cdto.getCno());
		return cboardDto;
	}

	// 댓글 수정 저장
	@Override
	public CboardDto cupdate(CboardDto cdto) {
		eventMapper.updateCboard(cdto);
		CboardDto cboardDto = eventMapper.selectOneCboard(cdto.getCno());
		return cboardDto;
	}

	// 댓글 삭제
	@Override
	public void cdelte(int cno) {
		eventMapper.deleteCboard(cno);
	}

}
