package kr.co.cofile.hdcdmybatis.service;

import kr.co.cofile.hdcdmybatis.domain.Board;
import kr.co.cofile.hdcdmybatis.exception.BoardNotFoundException;
import kr.co.cofile.hdcdmybatis.exception.BoardRegistrationException;

import java.util.List;

public interface BoardService {
    Board read(Integer id) throws BoardNotFoundException;
    List<Board> readAll();
    Board update(Board board) throws BoardNotFoundException;
    void delete(Integer id) throws BoardNotFoundException;
    Board register(Board board) throws BoardRegistrationException;
}
