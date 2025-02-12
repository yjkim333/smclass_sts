package com.java.service;

import java.util.ArrayList;
import java.util.Map;

import com.java.dto.BoardDto;

public interface CustomerService {
	
	// notice list + search
	Map<String, Object> notice(String search_option, String search_word);

	// nview
	Map<String, Object> nview(int bno);

}
