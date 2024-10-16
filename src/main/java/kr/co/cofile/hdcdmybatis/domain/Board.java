package kr.co.cofile.hdcdmybatis.domain;

import java.io.Serial;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
// 빌더 패턴
@Builder
// 모든 속성
@AllArgsConstructor
// 기본
@NoArgsConstructor
// 속성을 지정해서
@RequiredArgsConstructor
@ToString
public class Board {
	@Serial
	private static final long serialVersionID = 1L;
	
	// 속성
    private int id;
    @NonNull
    private String title;
    @NonNull
    private String content;
    @NonNull
    private String writer;
    private LocalDateTime createTime;
    
//    public Board() {
//    	super();
//    }
//    public Board(String title, String content, String writer) {
//    	this.title = title;
//    	this.content = content;
//    	this.writer = writer;
//    }
    
//	public String getTitle() {
//		return title;
//	}
//	public void setTitle(String title) {
//		this.title = title;
//	}
    
    
}
