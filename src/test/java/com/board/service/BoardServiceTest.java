package com.board.service;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.board.model.BoardVO;
import com.board.model.Criteria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardServiceTest {

	@Autowired
	private BoardService service;

	private static final Logger log = LoggerFactory.getLogger(BoardServiceTest.class);

	// 게시판 등록 테스트
//	@Test
//	public void testEnroll() {
//
//		BoardVO vo = new BoardVO();
//
//		vo.setTitle("service test");
//		vo.setContent("service test");
//		vo.setWriter("service test");
//
//		service.enroll(vo);
//	}

	// 게시판 목록 테스트
//	@Test
//	public void testGetList() {
//		service.getList().forEach(board -> log.info("" + board));
//	}

	// 게시판 조회 테스트
//	@Test
//	public void testGetPage() {
//		int bno = 8;
//		log.info("" + service.getPage(bno));
//	}

	// 게시판 수정 테스트
//	@Test
//	public void testModify() {
//		BoardVO board = new BoardVO();
//
//		board.setBno(9);
//		board.setTitle("service title modify test!");
//		board.setContent("service content modify test!");
//
//		int result = service.modify(board);
//
//		log.info("result : " + result);
//		
//		// 수정 후 조회
//		log.info("" + service.getPage(board.getBno()));
//	}
	
	// 게시판 삭제 테스트
//	@Test
//	public void testDelete() {
//		int result = service.delete(8);
//		// 삭제가 완료되면 result에 1이, 실패하면 0이 반환
//		log.info("result : " + result);
//	}
	
	// 게시판 목록(페이징) 테스트
	@Test
	public void testGetListPaging() {
		Criteria cri = new Criteria();
		
		cri.setPageNum(2);
		
		List list = service.getListPaging(cri);
		
		// lambda forEach
		// 배열에서 forEach 함수를 사용하기 위해서는 Stream API를 이용
		// ex) String[] strArray = { "a", "p", "p", "l", "e" };
		// Arrays.stream(strArray).forEach(s -> System.out.println(s));
		list.forEach(board -> log.info("" + board));
	}
}
