package com.java.service;

import java.util.List;

import com.java.dto.CboardDto;
import com.java.dto.EventDto;

public interface EventService {

	// 이벤트 리스트
	List<EventDto> findAll();

	// 이벤트 1개 가져오기 상세보기
	EventDto findByEno(int eno);

	// 이벤트 글 작성
	void eventSave(EventDto edto);



}
