package com.java.dto;

import java.sql.Timestamp;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // jpa
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MemberDto {
	
	@Id // pk 지정
	private String id;
	
	@Column(nullable = false, length = 100) // not null, varchar2(100)
	private String pw;
	
	@Column(nullable = false, length = 30) // not null, varchar2(30)
	private String name;
	
	@Column(length = 20)
	private String phone;
	
	@ColumnDefault("'남자'")
	private String gender;
	
	private String hobby;
	
	@UpdateTimestamp
	private Timestamp mdate;
	
}