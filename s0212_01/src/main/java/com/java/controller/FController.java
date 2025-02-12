package com.java.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.java.dto.BoardDto;
import com.java.service.BoardService;


@Controller	// jsp 페이지를 열어달라고 요청
public class FController {
	
	@Autowired BoardService boardService;
	
	// main
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	// rpage
	@ResponseBody // 데이터를 요청
	@GetMapping("/rpage")
	public String rpage() {
		return "리턴되는 데이터 내용";
	}
	
	// blist
	@GetMapping("/board/blist")
	public String blist(Model model) {
		ArrayList<BoardDto> list = boardService.blist();
		model.addAttribute("list", list);
		return "blist";
	}
	
	// bwrite
	@GetMapping("/board/bwrite")
	public String bwrite() {
		return "bwrite";
	}
	
	// bwrite 게시글 저장 // 첨부파일 1개 업로드  // @RequestPart MultipartFile files = 첨부파일 가져옴
	@PostMapping("/board/bwrite")
	public String bwrite(BoardDto bdto, @RequestPart MultipartFile files) {
		
		String real_fname = ""; // 변경파일명
		
		if(!files.isEmpty()) { // 첨부된 파일이 있으면
			// 원래 파일명 -> 중복 방지 위해 "랜덤문자_파일명" or "시간_파일명" 으로 이름 변경
			String origin_fname = files.getOriginalFilename();
			System.out.println("원래 파일명 : "+origin_fname);
			// UUID - 랜덤문자 생성 객체
			// UUID uuid = UUID.randomUUID();
			// String uname = uuid+"_"+origin_fname;
			long time = System.currentTimeMillis();
			real_fname = String.format("%d_%s",time,origin_fname); // 중복된 파일명 방지.
			System.out.println("변경 파일명 : "+real_fname);
			
			// 파일 저장 위치
			//String url = "C:/workspace/worksts/s0212_01/src/main/resources/static/upload/";
			String url = "C:/upload/board/";
			
			// 파일 저장
			File f = new File(url+real_fname);
			
			// 파일 업로드
			try {
				files.transferTo(f);
				// Dto에 파일이름 저장
				bdto.setBfile(real_fname);
				
			} catch (Exception e) {e.printStackTrace();}
		}else {
			bdto.setBfile("");
		}//isEmpty()
		System.out.println("파일 업로드 성공!!!");
		
		// 게시글 저장
		boardService.bwrite(bdto);
		
		
		return "redirect:/board/blist";
	}
	
	
//	// bwrite 게시글 저장 // 첨부파일 여러개 업로드  // @RequestPart MultipartFile files = 첨부파일 가져옴
//	@PostMapping("/board/bwrite")
//	public String bwrite(BoardDto bdto, List<MultipartFile> files) throws Exception {
//		String real_fname = ""; // 변경파일명
//		if(!files.isEmpty()) { // 첨부된 파일이 있으면
//			for(MultipartFile file : files) {
//				// 원래 파일명 -> 중복 방지 위해 "랜덤문자_파일명" or "시간_파일명" 으로 이름 변경
//				String origin_fname = files.getOriginalFilename();
//				System.out.println("원래 파일명 : "+origin_fname);
//				// UUID - 랜덤문자 생성 객체
//				// UUID uuid = UUID.randomUUID();
//				// String uname = uuid+"_"+origin_fname;
//				long time = System.currentTimeMillis();
//				real_fname = String.format("%d_%s",time,origin_fname); // 중복된 파일명 방지.
//				System.out.println("변경 파일명 : "+real_fname);
//				// 파일 저장 위치
//				String url = "C:/upload/board/";
//				// 파일 저장
//				File f = new File(url+real_fname);
//				// 파일 업로드
//				files.transferTo(f);
//			}
//			// Dto에 파일이름 저장
//			bdto.setBfile(real_fname);
//		}else {
//			bdto.setBfile("");
//		}//isEmpty()
//		System.out.println("파일 업로드 성공!!!");
//		// 게시글 저장
//		boardService.bwrite(bdto);
//		return "redirect:/board/blist";
//	}
	
	
	// bview
	@GetMapping("/board/bview")
	public String bview(int bno,Model model) {
		BoardDto bdto = boardService.bview(bno);
		model.addAttribute("bdto", bdto);
		return "bview";
	}
	
}
