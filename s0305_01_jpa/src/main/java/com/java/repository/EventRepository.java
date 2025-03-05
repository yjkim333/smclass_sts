package com.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.dto.EventDto;

public interface EventRepository extends JpaRepository<EventDto, Integer> {

	// 이벤트 1개 가져오기 상세보기
	EventDto findByEno(int eno);


}
