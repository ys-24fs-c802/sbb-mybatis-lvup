package kr.co.cofile.hdcdmybatis.mapper;

import kr.co.cofile.hdcdmybatis.domain.Board;
import kr.co.cofile.hdcdmybatis.exception.BoardNotFoundException;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DuplicateKeyException;

import java.util.List;
import java.util.Optional;

@Mapper
public interface BoardMapper {
    Optional<Board> getBoardById(Integer id);
    List<Board> getAllBoards();
    // 성공 1, 실패 0
    Board insertBoard(Board board) throws DuplicateKeyException;
    Board updateBoard(Board board) throws BoardNotFoundException;
    int deleteBoard(Integer id) throws BoardNotFoundException; // 삭제된 레코드의 수
}
