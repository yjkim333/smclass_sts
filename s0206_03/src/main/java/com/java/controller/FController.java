package com.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.dto.MemDto;
import com.java.dto.StuDto;
import com.java.service.BService;
import com.java.service.BServiceImpl;
import com.java.service.BServiceImpl2;
import com.java.service.BServiceImpl3;
import com.java.service.BServiceImpl4;


@Controller
public class FController {
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/member")
	public String member() {
		return "member";
	}
	
	// 매개변수로 전달받음
//	@PostMapping("/member")
//	public String member(String id,String pw,String name,String tel,String gender,String[] hobbys, Model model) {
//		String hobby = "";
//		for(int i=0;i<hobbys.length;i++) {
//			if(i == 0) hobby += hobbys[i];
//			else hobby += ","+hobbys[i];
//		}
//		model.addAttribute("mem", new MemDto(id,pw,name,tel,gender,hobby));
//		return "meminfo";
//	}
	
	@PostMapping("/meminfo")
	public String member(MemDto mDto, Model model) {
		System.out.println("mDto hobby : "+mDto.getHobby());
		
		model.addAttribute("mem", mDto);
		return "meminfo";
	}
	
	
	
	@GetMapping("/stuInput")
	public String stuInput() {
		return "stuInput";
	}
	
	@PostMapping("doStuInput")
	public String doStuInput(StuDto sDto, Model model) {
		
		sDto.setTotal(sDto.getKor()+sDto.getEng()+sDto.getMath());
		sDto.setAvg(sDto.getTotal()/3.0);
		sDto.setRank(0);
		model.addAttribute("stu", sDto);
		
		return "doStuInput";
	}

	
	
	@GetMapping("/data")
	public String data(@RequestParam(defaultValue = "1") int bno, Model model) {
		System.out.println("bno : "+bno);
		model.addAttribute("bno", bno);
		return "data";
	}
	
	//@PathVariable
	@GetMapping("/data2/{bno}")
	public String data2(@PathVariable int bno,Model model) {
		model.addAttribute("bno", bno);
		
		return "data2";
	}
	
	//@PathVariable - 여러개 받음
	@GetMapping("/data3/{bno}")
	public String data3(@PathVariable List<Integer> bno, Model model) {
		System.out.println("bno : "+bno);
		model.addAttribute("bno", bno);
		
		return "data3";
	}
	
	@Autowired BService b;
	
	@GetMapping("/data4")
	public String data4() {
		String str = b.slist();
		System.out.println("str : "+str);
		
		return "data4";
	}
	
	
	
	
	
}
