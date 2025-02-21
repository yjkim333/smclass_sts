package com.java.dto;

import java.sql.Timestamp;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor		// 기본생성자
@AllArgsConstructor		// 전체생성자
@Data					// @Setter, @Getter

@DynamicInsert // 데이터값이 null 일 경우 컬럼에서 제외 시킴
@Entity //  jpa 자동생성 - memberdto 테이블 : 컬럼생성, varchar2(50)
public class MemberDto {
	@Id // pk 생성
	@Column(length=100)
	private String id;
	
	@Column(nullable = false, length=100)
	private String pw;
	
	@Column(nullable = false, length=50)
	private String name;
	
	@Column(length=20)
	private String phone;
	
	@ColumnDefault(" '남자' ")
	private String gender;
	
	@Column(length = 100)
	private String hobby;
	
	@CreationTimestamp	// 시간 자동 입력 = sysdate
	private Timestamp mdate;
	
}
