package kr.co.cofile.hdcdmybatis.service;

import org.springframework.stereotype.Service;

import kr.co.cofile.hdcdmybatis.domain.Board;

public interface BoardService {

	Board read(Integer id);
	
}
