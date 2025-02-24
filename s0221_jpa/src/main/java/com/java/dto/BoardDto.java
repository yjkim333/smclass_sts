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
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity // jpa
public class BoardDto {
	
	@Id // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 시퀀스 자동 생성
	/*
	 * @SequenceGenerator(
	 *  name = "board_seq_generator", // 시퀀스 이름
	 *  sequenceName = "boarddto_seq", // boarddto_seq 이름의 시퀀스 생성
	 *  initialValue = 1, // 시작값
	 *  allocationSize = 1 // 메모리를 통한 할당범위 
	 *  )
	 */
	private int bno;
	@Column(nullable = false, length=100)
	private String btitle;
	
	@Lob // 대용량 데이터
	private String bcontent;
	
	@ManyToOne(fetch = FetchType.EAGER) // boardTomember - 여러보드에 작성자(fk)는 하나만
	@JoinColumn(name = "id")	// FK가 id라고 설정 - memberdto의 id를 조인사용하겠다. => select * from boarddto a, memberdto b where a.id = b.id
	private MemberDto memberDto; // memberdto 테이블의 pk - 객체 타입 입력불가 => jpa는 객체로 가능
//	private String id; // db에서도 id만 저장
	
	private int bgroup;
	
	@ColumnDefault("0") // 숫자 -> "0", 문자 ->"'남자'"
	private int bstep;
	
	@ColumnDefault("0") // 숫자 -> "0", 문자 ->"'남자'"
	private int bindent;
	
	@ColumnDefault("0") // 숫자 -> "0", 문자 ->"'남자'"
	private int bhit;
	
	@UpdateTimestamp // 자동 시간 입력
	private Timestamp bdate;
	
	@Column(nullable = true, length = 100)
	private String bfile;
	
}
