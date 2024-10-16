package kr.co.cofile.hdcdmybatis.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.cofile.hdcdmybatis.domain.Board;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/boards")
public class BoardController {
	@GetMapping
	public ResponseEntity<List<Board>> getBoards() {
		LocalDateTime now = LocalDateTime.now();
        
		// 롬복 @Builder
		Board board1 = Board.builder()
				.id(1)
				.title("t1")
				.content("c1")
				.writer("hong")
				.createTime(now)
				.build();
		// @NoArgsConstructor
		Board board2 = new Board();
		board2.setId(2);
		board2.setTitle("t2");
		board2.setContent("c2");
		board2.setWriter("hong");
		board2.setCreateTime(now);
		// @RequiredArgsConstructor
		Board board3 = new Board("t3","c3","hong");
		board3.setId(3);
		board3.setCreateTime(now);
		// @AllArgsConstructor
		Board board4 = new Board(4, "t4","c3","hong", now);
		
		List<Board> boardList = new ArrayList<>();
		boardList.add(board1);
		boardList.add(board2);
		boardList.add(board3);
		boardList.add(board4);
		
		return ResponseEntity.ok(boardList);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Board> getBoard(@PathVariable("id") int id) {
		log.info("상세보기: {}", id);
		Board board1 = Board.builder()
				.id(1)
				.title("t1")
				.content("c1")
				.writer("hong")
				.createTime(LocalDateTime.now())
				.build();
		
		return ResponseEntity.ok(board1);
	}
	
	@PostMapping
	public Map<String, Object> addBoard(@RequestBody Board board) {
		log.info(board.toString());
		// DB에 board를 성공적으로 등록했다 가정한다.
		board.setId(17);
		board.setCreateTime(LocalDateTime.now());
		
		Map<String, Object> result = new HashMap<>();
		result.put("message", "게시글 정보 등록 성공");
		result.put("board", board);
		return result;
	}
}
