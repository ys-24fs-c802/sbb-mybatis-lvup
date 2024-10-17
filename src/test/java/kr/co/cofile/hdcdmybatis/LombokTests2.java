package kr.co.cofile.hdcdmybatis;

import kr.co.cofile.hdcdmybatis.domain.Board2;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class LombokTests2 {

    @Test
    public void testGetters() {
        Board2 board = new Board2("제목 테스트","내용 테스트1","홍길동");

        board.setId(1);
        System.out.println(board);
    }

    @Test
    public void testHashCode() {
        Board2 board1 = new Board2("제목 테스트","내용 테스트1","홍길동");
        Board2 board2 = new Board2("제목 테스트","내용 테스트1","홍길동");
        board2.setId(2);

        System.out.println(board1.hashCode());
        System.out.println(board2.hashCode());
    }

    @Test
    public void testEquals() {
        Board2 board1 = new Board2("제목 테스트","내용 테스트1","홍길동");
        board1.setId(1);
        Board2 board2 = new Board2("제목 테스트","내용 테스트2","홍길동");
        board2.setId(2);
        Board2 board3 = new Board2("제목 테스트3","내용 테스트3","홍길동");
        board3.setId(3);

        Set<Board2> boardSet = new HashSet<>();
        boardSet.add(board1);
        boardSet.add(board2);
        boardSet.add(board3);

        for (Board2 board : boardSet) {
            System.out.println(board);
        }
    }

    @Test
    public void testRequiredArgsConstructor() {
        Board2 board = new Board2("제목 테스트","내용 테스트","홍길동");

        // @ToString의 exclude 파라미터 적용
        System.out.println(board);
    }

}
