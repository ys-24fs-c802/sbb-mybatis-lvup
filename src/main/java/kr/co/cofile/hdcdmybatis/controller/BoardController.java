package kr.co.cofile.hdcdmybatis.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.cofile.hdcdmybatis.domain.Board;
import kr.co.cofile.hdcdmybatis.exception.BoardNotFoundException;
import kr.co.cofile.hdcdmybatis.service.BoardService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/boards")
public class BoardController {
	
	@Autowired
	BoardService boardService;

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
    public ResponseEntity<Board> getBoard(@PathVariable("id") int id) {
        log.info("getBoard({})", id);

        Board board = boardService.read(id);

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
    
    @ExceptionHandler(BoardNotFoundException.class)
    public ResponseEntity<String> handleMyException(BoardNotFoundException e) {
        return ResponseEntity.badRequest().body("An error occurred: " + e.getMessage());
    }
}
