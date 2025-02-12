package com.java.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.CustomerMapper;
import com.java.dto.BoardDto;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired CustomerMapper customerMapper;
	
	// notice list
	@Override
	public Map<String, Object> notice(String search_option, String search_word) {
		Map<String, Object> map = customerMapper.selectAll(search_option,search_word);
		return map;
	}

	
	// nview
	@Override
	public Map nview(int bno) {
		Map<String, Object> map = new HashMap<>();
		// 게시글 1개 가져오기
		BoardDto bdto = customerMapper.selectOne(bno);
		// 이전 게시글 가져오기
		BoardDto prev_bdto = customerMapper.selectPrev(bno);
		// 다음 게시글 가져오기
		BoardDto next_bdto = customerMapper.selectNext(bno);
		
		map.put("bdto", bdto);
		map.put("prev_bdto", prev_bdto);
		map.put("next_bdto", next_bdto);
		
		return map;
	}

	

}
