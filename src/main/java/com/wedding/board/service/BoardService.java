package com.wedding.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.wedding.board.dao.BoardDAO;
import com.wedding.board.dto.BoardDTO;
import com.wedding.board.dto.Criteria;
import com.wedding.board.dto.SearchCriteria;

@Service
public class BoardService {

	@Inject
	private BoardDAO boardDAO;
	
	
	public void write(BoardDTO boardDTO) throws Exception {
		boardDAO.write(boardDTO);
	}

	public List<BoardDTO> list() throws Exception {
		return boardDAO.list();
	}

	public BoardDTO read(int bno) throws Exception {
		return boardDAO.read(bno);
	}
	
	public void update(BoardDTO boardDTO) throws Exception {
		boardDAO.update(boardDTO);
	}

	public void delete(int bno) throws Exception {
		boardDAO.delete(bno);
	}
	
	public List<BoardDTO> list(Criteria criteria) throws Exception {
		return boardDAO.listPage(criteria);
	}
	
	public int listCount() throws Exception {
		return boardDAO.listCount();
	}
	
	public List<BoardDTO> list(SearchCriteria scriteria) throws Exception {
		return boardDAO.listPageSearch(scriteria);
	}
	
	public int listCount(SearchCriteria scriteria) throws Exception {
		return boardDAO.listCountSearch(scriteria);
	}
	

}
