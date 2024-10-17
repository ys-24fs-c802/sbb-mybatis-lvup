package kr.co.cofile.hdcdmybatis.service;

import kr.co.cofile.hdcdmybatis.domain.Board;
import kr.co.cofile.hdcdmybatis.exception.BoardNotFoundException;
import kr.co.cofile.hdcdmybatis.exception.BoardRegistrationException;
import kr.co.cofile.hdcdmybatis.mapper.BoardMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper;

    @Autowired
    public BoardServiceImpl(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    @Override
    public Board read(Integer id) throws BoardNotFoundException {
        return boardMapper.getBoardById(id)
                .orElseThrow(() -> new BoardNotFoundException("Board not found with id: " + id));
    }

    @Override
    public List<Board> readAll() {
        List<Board> boardList = boardMapper.getAllBoards();
        if (boardList.isEmpty()) {
            // 로깅을 추가하고, 빈 리스트를 반환합니다. 예외를 던지지 않습니다.
            log.info("No boards found");
        }
        return boardList;
    }

    @Override
    public Board register(Board board) throws BoardRegistrationException {
        try {
            return boardMapper.insertBoard(board);
        } catch (DuplicateKeyException e) {
            throw new BoardRegistrationException("Failed to register board due to duplication", e);
        } catch (DataIntegrityViolationException e) {
            throw new BoardRegistrationException("Failed to register board due to data integrity violation", e);
        } catch (Exception e) {
            throw new BoardRegistrationException("Unexpected error occurred while registering board", e);
        }
    }

    @Override
    public Board update(Board board) throws BoardNotFoundException {
        Board updatedBoard = boardMapper.updateBoard(board);
        if (updatedBoard == null) {
            throw new BoardNotFoundException("Board not found with id: " + board.getId());
        }
        return updatedBoard;
    }

    @Override
    public void delete(Integer id) throws BoardNotFoundException {
        int deleted = boardMapper.deleteBoard(id);
        if (deleted > 0) {
            throw new BoardNotFoundException("Board not found with id: " + id);
        }
    }
}
