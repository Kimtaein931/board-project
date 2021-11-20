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

	// 게시판 목록 페이지 이동 GET
	@GetMapping("/list")
	public void boardListGet(Model model) {

		log.info("게시판 목록 페이지 진입");
		
		model.addAttribute("list", boardService.getList());

	}

	// 게시판 등록 페이지 이동 GET
	@GetMapping("/enroll")
	public void boardEnrollGET() {

		log.info("게시판 등록 페이지 진입");

	}

	// 게시판 등록 POST
	@PostMapping("/enroll")
	public String boardEnrollPOST(BoardVO board, RedirectAttributes rttr) {

		log.info("BoardVO : " + board);

		boardService.enroll(board);

		// addFlashAttribute()를 사용한 이유는 '일회성'으로만 데이터를 전달하기 위함이다.
		rttr.addFlashAttribute("result", "enroll success");

		return "redirect:/board/list";

	}
	
	// 게시판 조회 GET
	@GetMapping("/get")
	public void boardGetPageGET(int bno, Model model) {
		
		model.addAttribute("pageInfo", boardService.getPage(bno));
		
	}
	
	// 게시판 수정 GET
	@GetMapping("/modify")
	public void boardModifyGET(int bno, Model model) {
		
		model.addAttribute("pageInfo", boardService.getPage(bno));
		
	}
	
	// 게시판 수정 POST
	@PostMapping("/modify")
	public String boardModifyPost(BoardVO board, RedirectAttributes rttr) {

		// RedirectAttribute
		// 수정 기능 실행 후 리다이렉트 방식으로 리스트 페이지 이동 시 데이터를 같이 전송하기 위해서
		// RedirectAttribute 객체를 파라미터로 부여함
		
		boardService.modify(board);

		// 리스트 페이지 이동 시 수정이 완료됐다는 경고창을 띄우기 위해
		// "modify success" 스트링 데이터를 result 속성 값에 저장하는 addFlashAttribute() 메소드를 호출하였음
		rttr.addFlashAttribute("result", "modify success");

		return "redirect:/board/list";
	}
	
	// 게시판 삭제 POST
	@PostMapping("/delete")
	public String boardDeletePOST(int bno, RedirectAttributes rttr) {
		boardService.delete(bno);
		
		// 삭제 쿼리를 실행하기 위해선 게시판 번호(bno)에 대한 정보가 필요로 하기 때문에 int형 변수를 parameter로 부여하였고
		// 삭제 후 리스트 페이지로 이동 시 데이터를 같이 전송하기 위해서 RedirectAttribute 객체를 parameter로 부여함
		
		// 삭제가 완료되었다는 alert을 띄우기 위해 "delete success" 스트링 데이터를 result 속성 값에 저장하는 addFlashAttribute() 메소드를 호출하였음
		// .addFlashAttribute : 1회성 데이터 전송
		rttr.addFlashAttribute("result", "delete success");
		
		return "redirect:/board/list";
	}
}
