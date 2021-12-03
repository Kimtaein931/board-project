package com.board.mapper;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

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
public class BoardMapperTests {

	private static final Logger log = LoggerFactory.getLogger(BoardMapperTests.class);

	@Autowired
	private BoardMapper mapper;

	// 게시판 등록 테스트
	/*
	 * @Test public void testEnroll() {
	 * 
	 * BoardVO vo = new BoardVO();
	 * 
	 * vo.setTitle("mapper test"); vo.setContent("mapper test");
	 * vo.setWriter("mapper test");
	 * 
	 * System.out.println("vo -> " + vo); mapper.enroll(vo);
	 * 
	 * }
	 */
	
	// 게시판 목록 테스트
//	@Test
//	public void testGetList() {
//		
//		List<BoardVO> list = mapper.getList();
//		
//		// 일반적인 for문
//		for(int i = 0; i < list.size(); i++) {
//			log.info("for List : " + list.get(i));
//		}
//		
//		// 향상된 for문(foreach문)
//		for(Object a : list) {
//			log.info("foreach List : " + a);
//		}
//		
//		// 향상된 for문 + 람다식
//		list.forEach(board -> log.info("foreach + lambda" + board));
//		
//	}
	
	// 게시판 조회 테스트
//	@Test
//	public void testGetPage() {
//		
//		int bno = 8;
//		
//		log.info("" + mapper.getPage(bno));
//	}
	
	// 게시판 수정 테스트
//	@Test
//	public void testModify() {
//		
//		BoardVO board = new BoardVO();
//		board.setBno(9);
//		board.setTitle("제목 수정 테스트2");
//		board.setContent("내용 수정 테스트2");
//		board.setWriter("작가 수정 테스트2");
//		
//		// 수정이 완료되면 result에 1이, 실패하면 0이 반환
//		int result = mapper.modify(board);
//		log.info("result : " + result);
//		
//		// 수정 후 목록 출력
//		log.info("" + mapper.getPage(board.getBno()));
//		
//	}
	
	// 게시판 삭제 테스트
//	@Test
//	public void testDelete() {
//		int result = mapper.delete(9);
//		// 삭제가 완료되면 result에 1이, 실패하면 0이 반환
//		log.info("result : " + result);
//	}
	
	// 게시판 목록(페이징) 테스트
//	@Test
//	public void testGetListPaging() {
//		
//		Criteria cri = new Criteria();
//		
//		cri.setPageNum(2);
//		
//		List list = mapper.getListPaging(cri);
//		
//		list.forEach(board -> log.info("" + board));
//	}
	
	// 게시글 전체 수
//	@Test
//	public void testGetTotal() {
//		int total = mapper.getTotal();
//		log.info("total : " + total);
//	}
}
