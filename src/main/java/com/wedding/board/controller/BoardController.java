package com.wedding.board.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wedding.board.dto.BoardDTO;
import com.wedding.board.dto.Criteria;
import com.wedding.board.dto.PageMaker;
import com.wedding.board.dto.SearchCriteria;
import com.wedding.board.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Inject
	BoardService service;

	// 게시판 글 작성 화면
	@RequestMapping(value = "/writeView", method = RequestMethod.GET)
	public void writeView() throws Exception {
		logger.info("writeView");

	}

	// 게시판 글 작성
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String write(BoardDTO boardDTO) throws Exception {
		logger.info("write");

		service.write(boardDTO);

		return "redirect:/board/list";
	}

	// 게시판 목록 조회
	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public String list(Model model) throws Exception {
		logger.info("listSTART");

		model.addAttribute("list", service.list());

		logger.info("listEND");
		return "/board/list";
	}
	
	//nomal list not search option
//	@RequestMapping(value = "/list", method = RequestMethod.GET)
//	public String list(Model model, Criteria cri) throws Exception{
//		logger.info("list");
//		
//		model.addAttribute("list", service.list(cri));
//		
//		PageMaker pageMaker = new PageMaker();
//		pageMaker.setCri(cri);
//		pageMaker.setTotalCount(service.listCount());
//		
//		model.addAttribute("pageMaker", pageMaker);
//		
//		return "board/list";
//	}
	
	// 게시판 목록 조회
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model, @ModelAttribute("scri") SearchCriteria scri) throws Exception{
		logger.info("list");
		
		model.addAttribute("list", service.list(scri));
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(scri);
		pageMaker.setTotalCount(service.listCount(scri));
		
		model.addAttribute("pageMaker", pageMaker);
		
		return "board/list";
		
	}

	// 게시판 조회
	@RequestMapping(value = "/readView", method = RequestMethod.GET)
	public String read(BoardDTO boardDTO, Model model) throws Exception {
		logger.info("read");

		model.addAttribute("read", service.read(boardDTO.getBno()));

		return "board/readView";
	}

	// 게시판 수정뷰
	@RequestMapping(value = "/updateView", method = RequestMethod.GET)
	public String updateView(BoardDTO boardVO, Model model) throws Exception{
		logger.info("updateView");
		
		model.addAttribute("update", service.read(boardVO.getBno()));
		
		return "board/updateView";
	}
	
	// 게시판 수정
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(BoardDTO boardVO) throws Exception{
		logger.info("update");
		
		service.update(boardVO);
		
		return "redirect:/board/list";
	}

	// 게시판 삭제
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(BoardDTO boardVO) throws Exception{
		logger.info("delete");
		
		service.delete(boardVO.getBno());
		
		return "redirect:/board/list";
	}
}
