package me.eun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import me.eun.mapper.BoardMapper;
import me.eun.model.BoardVO;

public class BoardServiceImpl implements BoardService {

	public BoardServiceImpl() {
		System.out.println("첫번째 구현체");
	}
	private BoardMapper mapper;
	
	@Autowired
	public void setMapper(BoardMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public List<BoardVO> readAll() {
		System.out.println("구현 BB 사용");
		return mapper.getList();
	}

	@Override
	public BoardVO read(Long bno) {
		return mapper.get(bno);
	}

	@Override
	public void register(BoardVO vo) {
		mapper.insert(vo);
	}

	@Override
	public void modify(BoardVO vo) {
		mapper.update(vo);
	}

	@Override
	public void remove(Long bno) {
		mapper.delete(bno);
	}

}
