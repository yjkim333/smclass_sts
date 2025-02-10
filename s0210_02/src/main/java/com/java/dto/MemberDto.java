package com.java.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor		// 기본생성자
@AllArgsConstructor		// 전체생성자
@Data					// @Setter, @Getter 
public class MemberDto {
	
	private String id;
	private String pw;
	private String name;
	private String phone;
	private String gender;
	private String hobby;
	private Timestamp mdate;
	
}