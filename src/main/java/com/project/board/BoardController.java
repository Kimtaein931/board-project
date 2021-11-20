package com.project.board;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.board.model.BoardVO;
import com.board.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	private static final Logger log = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	private BoardService boardService;

	// 게시판 목록 페이지 이동
	@GetMapping("/list")
	public void boardListGet(Model model) {

		log.info("게시판 목록 페이지 진입");
		
		model.addAttribute("list", boardService.getList());

	}

	// 게시판 등록 페이지 이동
	@GetMapping("/enroll")
	public void boardEnrollGET() {

		log.info("게시판 등록 페이지 진입");

	}

	// 게시판 등록
	@PostMapping("/enroll")
	public String boardEnrollPOST(BoardVO board, RedirectAttributes rttr) {

		log.info("BoardVO : " + board);

		boardService.enroll(board);

		// addFlashAttribute()를 사용한 이유는 '일회성'으로만 데이터를 전달하기 위함이다.
		rttr.addFlashAttribute("result", "enroll success");

		return "redirect:/board/list";

	}
	
	// 게시판 조회
	@GetMapping("/get")
	public void boardGetPageGET(int bno, Model model) {
		
		model.addAttribute("pageInfo", boardService.getPage(bno));
		
	}
}
