package kr.co.cofile.hdcdmybatis.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.cofile.hdcdmybatis.domain.Board;
import kr.co.cofile.hdcdmybatis.exception.BoardNotFoundException;
import kr.co.cofile.hdcdmybatis.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardMapper boardMapper;
	
	@Override
	public Board read(Integer id) {
		// 요청객체가 없을때 NullPointException 발생
		// Board != Optional<Board>
		return boardMapper.read(id).orElseThrow(() -> new BoardNotFoundException("게시물을 찾을 수 없습니다. 14:52"));
	}

}
