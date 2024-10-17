package kr.co.cofile.hdcdmybatis.controller;

import kr.co.cofile.hdcdmybatis.domain.Board;
import kr.co.cofile.hdcdmybatis.exception.BoardRegistrationException;
import kr.co.cofile.hdcdmybatis.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/boards")
public class BoardController {

    private final BoardService boardService;
    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping
    public ResponseEntity<List<Board>> getBoards() {
        log.info("getBoards");

        List<Board> boardList = boardService.readAll();

        return ResponseEntity.ok(boardList);
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> addBoard(@Validated @RequestBody Board board) throws BoardRegistrationException {
        log.info("addBoard");
        log.info(board.toString());

        Board savedBoard = boardService.register(board);

        Map<String, Object> map = new HashMap<>();
        map.put("message", "success");
        map.put("board", savedBoard);

        return ResponseEntity.status(HttpStatus.CREATED).body(map);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Board> getBoard(@PathVariable int id) {
        log.info("getBoard({})", id);

        Board board = boardService.read(id);

        return new ResponseEntity<>(board, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBoard(@PathVariable int id) {
        log.info("deleteBoard({})", id);

        boardService.delete(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateBoard(@PathVariable int id, @RequestBody Board board) {
        log.info("updateBoard({})", id);
        log.info(board.toString());

        board.setId(id);  // 경로 변수의 ID를 보드 객체에 설정
        Board updatedBoard = boardService.update(board);

        Map<String, Object> map = new HashMap<>();
        map.put("message", "success");
        map.put("board", updatedBoard);

        return ResponseEntity.ok(map);
    }
}
