package me.eun.mapper;

import java.util.List;

import me.eun.model.BoardVO;

public interface BoardMapper {
	
	List<BoardVO> getList();
	BoardVO get (Long bno);
	void insert(BoardVO vo);
	void update(BoardVO vo);
	void delete(Long bno);
}
