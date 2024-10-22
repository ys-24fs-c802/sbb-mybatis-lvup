package kr.co.cofile.hdcdmybatis.mapper;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import kr.co.cofile.hdcdmybatis.domain.Board;

@Mapper
public interface BoardMapper {
	Optional<Board> read(Integer id);
}
