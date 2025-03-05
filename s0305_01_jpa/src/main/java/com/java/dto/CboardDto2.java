package com.java.dto;

import java.sql.Timestamp;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class CboardDto2 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 시퀀스 사용
	private int cno;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "eno")
	private EventDto edto;
	//private int eno;
	
	@ManyToOne
	@JoinColumn(name = "id") // CboardDtoId
	private MemberDto mdto;
//	private String id;
	
	@Column(nullable = true, length = 100)
	private String cpw;
	
	@Column(length = 1000)
	private String ccontent;
	
	@UpdateTimestamp
	private Timestamp cdate;
}
