package com.java.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@NoArgsConstructor	// 기본생성자
@AllArgsConstructor // 전체생성자
@Data				// getter, setter 둘 다 생성
//@Setter	// setter 생성
//@Getter	// getter 생성
public class MemberDto {
	private String id;
	private String pw;
	private String name;
	private String tel;
	private String gender;
	private String hobby;
}
