package com.wedding.board.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.wedding.board.dto.BoardDTO;
import com.wedding.board.dto.Criteria;
import com.wedding.board.dto.SearchCriteria;

@Repository
public class BoardDAO {

	private static final Logger logger = LoggerFactory.getLogger(BoardDAO.class);

	
	@Inject
    private SqlSession sqlSession;

	public void write(BoardDTO boardDTO) throws Exception {
		 sqlSession.insert("boardMapper.insert",boardDTO); 
	}

	public List<BoardDTO> list() throws Exception {
		return sqlSession.selectList("boardMapper.list");
	}

	public BoardDTO read(int bno) throws Exception {
		return sqlSession.selectOne("boardMapper.read", bno);
	}
	
	public void update(BoardDTO boardDTO) throws Exception {
		int result = sqlSession.update("boardMapper.update", boardDTO);
		logger.info("Update Result :" + result);
	}
	
	public void delete(int bno) throws Exception {
		int result = sqlSession.delete("boardMapper.delete", bno);
		logger.info("Update Result :" + result);
	}
	
	public List<BoardDTO> listPage(Criteria criteria) throws Exception {
		return sqlSession.selectList("boardMapper.listPage",criteria);
	}
	
	public int listCount() throws Exception {
		return sqlSession.selectOne("boardMapper.listCount");
	}
	
	public List<BoardDTO> listPageSearch(SearchCriteria scriteria) throws Exception {
		return sqlSession.selectList("boardMapper.listPageSearch",scriteria);
	}
	
	public int listCountSearch(SearchCriteria scriteria) throws Exception {
		return sqlSession.selectOne("boardMapper.listCountSearch", scriteria);
	}
}
