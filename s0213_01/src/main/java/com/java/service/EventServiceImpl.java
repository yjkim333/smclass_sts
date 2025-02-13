package com.java.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.EventMapper;
import com.java.dto.CboardDto;
import com.java.dto.EventDto;

@Service
public class EventServiceImpl implements EventService {

	@Autowired EventMapper eventMapper;
	
	// 이벤트리스트 가져오기
	@Override
	public ArrayList<EventDto> event_list() {
		ArrayList<EventDto> list = eventMapper.selectAll();
		return list;
	}

	// 이벤트 상세보기
	@Override
	public EventDto event(int eno) {
		EventDto edto = eventMapper.selectOne(eno);
		return edto;
	}
	
	// 전체 댓글 가져오기
	@Override
	public ArrayList<CboardDto> clist(int eno) {
		ArrayList<CboardDto> clist = eventMapper.selectAllCboard(eno);
		return clist;
	}

}
