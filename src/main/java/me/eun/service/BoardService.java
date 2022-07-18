package me.eun.service;

import java.util.List;

import me.eun.model.BoardVO;

public interface BoardService {

	List<BoardVO> readAll();
	BoardVO read (Long bno);
	void register (BoardVO vo);
	void modify(BoardVO vo);
	void remove (Long bno);
}
