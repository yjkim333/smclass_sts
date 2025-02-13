package com.java.service;

import java.util.ArrayList;

import com.java.dto.CboardDto;
import com.java.dto.EventDto;

public interface EventService {

	// 이벤트리스트 가져오기
	ArrayList<EventDto> event_list();

	// 이벤트 상세보기
	EventDto event(int eno);

	// 전체 댓글 가져오기
	ArrayList<CboardDto> clist(int eno);

}
