package com.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class FController {
	
	
	//main
	@GetMapping("/")
	public String index() {
		return "index";
	}
	

	
	
}
