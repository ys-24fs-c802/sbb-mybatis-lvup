package kr.co.cofile.hdcdmybatis;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import kr.co.cofile.hdcdmybatis.domain.Board;

public class LombokTests {

	@Test
	public void testGetter() {
		Board board = new Board();
//		board.setTitle("제목 테스트");
//		board.setContent("내용 테스트1");
//		board.setWriter("홍길동");
		
		board.setTitle("제목 테스트");
		System.out.println(board.getTitle());
	}
	
	@Test
	public void testHashCode() {
		Board board = new Board();
		Board board2 = new Board("제목 테스트", "내용 테스트1", "홍길동");
		Board board3 = new Board("제목 테스트", "내용 테스트1", "홍길동");
		
		System.out.println(board.hashCode());
		System.out.println(board2.hashCode());
		System.out.println(board2.hashCode());
	}
	
	@Test
	public void testEquals() {
		Board board1 = new Board("제목 테스트", "내용 테스트1", "홍길동");
		Board board2 = new Board("제목 테스트", "내용 테스트1", "홍길동");
		Board board3 = new Board("제목 테스트", "내용 테스트1", "홍길동");
		
		Set<Board> boardSet = new HashSet<>();
		boardSet.add(board1);
		boardSet.add(board2);
		boardSet.add(board3);
		
		for(Board board : boardSet) {
			System.out.println(board);
		}
	}
	
	@Test
	public void testBuilderSetter() {
		Board board1 = Board.builder()
				.title("제목 테스트")
				.content("내용 테스트1")
				.writer("홍길동")
				.build();
		
		System.out.println(board1);
				
	}
}
