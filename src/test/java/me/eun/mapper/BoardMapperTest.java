package me.eun.mapper;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import me.eun.AppTest;
import me.eun.model.BoardVO;

public class BoardMapperTest extends AppTest{

	
	@Autowired
	BoardMapper mapper;
	
	
	@Test
	public void getListtest() {
		mapper.getList();
	}
	@Ignore
	@Test
	public void getTest() {
		mapper.get(1L);
	}
	@Ignore
	@Test
	public void insertTest() {
		BoardVO vo = new BoardVO();
		vo.setTitle("제목테스트");
		vo.setContent("내용테스트");
		vo.setWriter("글쓴이");
		mapper.insert(vo);
	}
	@Test
	@Ignore
	public void updateTest() {
		BoardVO vo = new BoardVO();
		vo.setBno(5L);
		vo.setTitle("제목테스트--수정");
		vo.setContent("내용테스트--수정");
		mapper.update(vo);
	}
	@Test
	public void deleteTest() {
		mapper.delete(5L);
	}
}
