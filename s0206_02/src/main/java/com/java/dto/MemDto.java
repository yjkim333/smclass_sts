package com.java.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder // 부분생성자
@Data
public class MemDto {
	
	private String id;
	private String pw;
	private String name;
	private String tel;
	private String gender;
	private String hobby;
	private int kor;
	private int eng;
	private int math;
	private int total;
	private double avg;
	
//	@Builder
//	public MemDto(String id, String pw) {
//		this.id = id;
//		this.pw = pw;
//	}
	
	
	
}
