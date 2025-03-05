package com.java.dto;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
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
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity // jpa 테이블 생성
@ToString(exclude = "clist") //clist 무한루프 방지 => json 데이터 호출시 @JsonIgnore 붙이기
public class EventDto {
	
	@Id // pk등록
	// 시퀀스 사용
	@GeneratedValue(strategy = GenerationType.IDENTITY) // DB의 시퀀스 사용 방법
	private int eno;
	
	@Column(nullable = false, length = 200)
	private String etitle;
	
	@Lob // 대용량 문자
	private String econtent;
	
	@ManyToOne(fetch = FetchType.EAGER) // 이벤트글 여러개 작성 <-> 유저한명 //EAGER - 즉시 데이터 가져옴.default
	@JoinColumn(name = "id") // fk로 MemberDto의 pk를 id라는 변수로 사용하겠다. name은 변경가능.
	private MemberDto memberDto;
	//private String id;
	
	@ColumnDefault("0") // 숫자 => "숫자" , 문자 => "'문자'"
	private int ehit;
	
	@UpdateTimestamp
	private Timestamp edate;
	
	private String efile;
	private String efile2;
	private Timestamp stdate;
	private Timestamp enddate;
	private int openchk;
	
	// 하단댓글
	@OneToMany(mappedBy = "edto", fetch = FetchType.EAGER) // 한 개의 이벤트에 여러개 댓글을 가져옴. // Lazy - 지연전략 default
	// mappedBy
	private List<CboardDto2> clist;
	
}

