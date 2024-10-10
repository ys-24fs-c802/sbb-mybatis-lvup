package kr.co.cofile.hdcdmybatis;

import kr.co.cofile.hdcdmybatis.domain.Board;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class LombokTests {

    @Test
    public void testGetters() {
        Board board = new Board();

        board.setTitle("제목 테스트");
        System.out.println(board);
    }

    @Test
    public void testHashCode() {
        Board board = new Board();
        Board board1 = new Board("제목 테스트", "내용 테스트1", "홍길동");
        Board board2 = new Board("제목 테스트", "내용 테스트1", "홍길동");
        board2.setId(2);

        System.out.println(board.hashCode());
        System.out.println(board1.hashCode());
        System.out.println(board2.hashCode());
    }

    @Test
    public void testEquals() {
        Board board1 = new Board("제목 테스트", "내용 테스트1", "홍길동");
        board1.setId(1);
        Board board2 = new Board("제목 테스트", "내용 테스트2", "홍길동");
        board2.setId(2);
        Board board3 = new Board("제목 테스트3", "내용 테스트3", "홍길동");
        board3.setId(3);

        Set<Board> boardSet = new HashSet<>();
        boardSet.add(board1);
        boardSet.add(board2);
        boardSet.add(board3);

        for (Board board : boardSet) {
            System.out.println(board);
        }
    }

    @Test
    public void testNoArgsConstructor() {
        Board board = new Board();

        System.out.println(board);
    }

    @Test
    public void testRequiredArgsConstructor() {
        Board board = new Board("제목 테스트", "내용 테스트", "홍길동");

        // @ToString의 exclude 파라미터 적용
        System.out.println(board);
    }

    @Test
    public void testAllArgsConstructor() {
        Board board = new Board(1, "제목 테스트", "내용 테스트", "홍길동", LocalDateTime.now());

        System.out.println(board);
    }

    @Test
    public void testBuilderSetter() {
        // title is marked non-null but is null
//        Board board = Board.builder()
//                .id(1)
//                .build();
        Board board1 = Board.builder()
                .title("제목 테스트")
                .content("내용 테스트")
                .writer("홍길동")
                .build();

//        System.out.println(board);
        System.out.println(board1);
    }
}
