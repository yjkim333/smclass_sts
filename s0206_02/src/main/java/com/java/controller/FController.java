package com.java.controller;

import java.lang.reflect.Member;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.dto.MemDto;
import com.java.dto.StuDto;

import jakarta.servlet.http.HttpServletRequest;


@Controller
public class FController {
	
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/login")
	public String login(HttpServletRequest request,
			@RequestParam("id") String id, 				     // form의 name="id" 데이터를 "id"로 입력받은
			@RequestParam(required = false) String pw,		 // required = false => null 값 허용
			String name, 								     // @RequestParam 생략가능, form name과 같아야함.
			@RequestParam int kor,
			@RequestParam(defaultValue = "0") int eng,       // defaultValue = "0" => 값이 없으면 0으로 처리
			int math, //@RequestParam 생략가능
			Model model) {
		int total = kor+eng+math;
		double avg = total/3.0;
//		String aid = request.getParameter("id");
//		String apw = request.getParameter("pw");
//		int akor = Integer.parseInt(request.getParameter("kor"));
//		int aeng = Integer.parseInt(request.getParameter("eng"));
//		int amath = Integer.parseInt(request.getParameter("math"));
//		int atotal = kor+eng+math;
//		double aavg = atotal/3.0;
//		
//		System.out.println("id : "+id+", pw : "+pw);
		
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		//model.addAttribute("mem", MemDto.builder().id(id).pw(pw).build());
		model.addAttribute("mem", MemDto.builder().id(id).pw(pw).kor(kor).eng(eng).math(math).total(total).avg(avg).build());
		
		MemDto m = new MemDto();
		MemDto m2 = MemDto.builder().id("bbb").pw("1111").build();
		
		return "doLogin";
	}
	
	
	@GetMapping("/stuInput")
	public String stuInput() {
		return "stuInput";
	}
	
	@PostMapping("/stuInput")
	public String stuInput(int stuno,String name, int kor, int eng, int math, Model model) {
		int total = kor+eng+math;
		double avg = total/3.0;
//		model.addAttribute("stuno", stuno);
//		model.addAttribute("name", name);
//		model.addAttribute("kor", kor);
//		model.addAttribute("eng", eng);
//		model.addAttribute("math", math);
//		model.addAttribute("total", total);
//		model.addAttribute("avg", avg);
		
		StuDto s = StuDto.builder().stuno(stuno).name(name).kor(kor).eng(eng).math(math).total(total).avg(avg).build();
		model.addAttribute("stu",s);
		
		return "doStuInput";
	}
	
	
	@GetMapping("/board")
	public String board(int bno, String btitle, Model model) {
		System.out.println("bno : "+bno);
		System.out.println("btitle : "+btitle);
		
		model.addAttribute("bno", bno);
		model.addAttribute("btitle", btitle);
		
		return "board";
	}
	
	
}
