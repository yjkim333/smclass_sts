package com.java.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.dto.CboardDto;
import com.java.dto.EventDto;
import com.java.repository.EventRepository;

@Service
@Transactional
public class EventServiceImpl implements EventService {

	@Autowired EventRepository eventRepository;
	
	// 이벤트 리스트
	@Override
	public List<EventDto> findAll() {
		List<EventDto> list = eventRepository.findAll();
		return list;
	}

	// 이벤트 1개 가져오기 상세보기
	@Override
	public EventDto findByEno(int eno) {
		EventDto edto = eventRepository.findByEno(eno);
		return edto;
	}

	// 이벤트 글 작성
	@Override
	public void eventSave(EventDto edto) {
		eventRepository.save(edto);
	}


}
