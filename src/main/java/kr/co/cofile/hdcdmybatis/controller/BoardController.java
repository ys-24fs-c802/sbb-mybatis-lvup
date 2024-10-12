package kr.co.cofile.hdcdmybatis.controller;

import kr.co.cofile.hdcdmybatis.domain.Board;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/boards")
public class BoardController {

    @GetMapping
    public ResponseEntity<List<Board>> getBoards() {
        log.info("getBoards");

        List<Board> boardList = new ArrayList<>();
        Board board = new Board();

        board.setId(1);
        board.setTitle("제목1");
        board.setContent("내용1");
        board.setWriter("hongkd");
        board.setCreateTime(LocalDateTime.now());

        boardList.add(board);

        board = new Board();

        board.setId(2);
        board.setTitle("제목2");
        board.setContent("내용2");
        board.setWriter("hongkd");
        board.setCreateTime(LocalDateTime.now());

        boardList.add(board);

        return ResponseEntity.ok(boardList);
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> addBoard(@RequestBody Board board) {
        log.info("addBoard");
        log.info(board.toString());

        // id=3 추가
        board.setId(3);

        Map<String, Object> result = new HashMap<>();
        result.put("message", "게시글 정보가 성공적으로 저장되었습니다.");
        result.put("board", board);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Board> getBoard(@PathVariable int id) {
        log.info("getBoard({})", id);

        Board board = new Board();

        board.setId(1);
        board.setTitle("제목1");
        board.setContent("내용1");
        board.setWriter("hongkd");
        board.setCreateTime(LocalDateTime.now());

        return new ResponseEntity<>(board, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBoard(@PathVariable int id) {
        log.info("deleteBoard({})", id);

        return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateBoard(@PathVariable int id, @RequestBody Board board) {
        log.info("updateBoard({})", id);
        log.info(board.toString());

        Map<String, Object> result = new HashMap<>();
        result.put("message", "게시글 정보가 성공적으로 수정되었습니다.");
        result.put("board", board);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
