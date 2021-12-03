<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
  src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous"></script>
  <style>
  a{
  	text-decoration : none;
  }
  table{
 	border-collapse: collapse;
 	width: 1000px;    
 	margin-top : 20px;
 	text-align: center;
  }
  td, th{
  	border : 1px solid black;
  	height: 50px;
  }
  th{
  	font-size : 15px;
  }
  td{
  	font-size : 12px;
  }
  thead{
  	font-weight: 700;
  }
  .table_wrap{
  	margin : 50px 0 0 50px;
  }
  .bno_width{
  	width: 12%;
  }
  .writer_width{
  	width: 20%;
  }
  .regdate_width{
  	width: 15%;
  }
  .updatedate_width{
  	width: 15%;
  }
  .top_btn{
  	font-size: 15px;
    padding: 6px 12px;
    background-color: #fff;
    border: 1px solid #ddd;
    font-weight: 600;
  }
  .pageInfo{
  	list-style: none;
  	display: inline-block;
  	margin: 50px 0 0 100px;
  }
  .pageInfo li{
  	float: left;
  	font-size: 15px;
  	margin-left: 18px;
  	padding: 7px;
  	font-weight: 500;
  }
  a:link{color:black; text-decoration: none;}
  a:visited{color:black; text-decoration: none;}
  a:hover{color:black; text-decoration: underline;}
  .active{
  	background-color: #cdd5ec;
  }
  .search_area{
  	display: inline-block;
  	margin-top: 30px;
  	margin-left: 260px;
  }
  .search_area input{
  	height: 30px;
  	width: 250px;
  }
  .search_area button {
  	width: 100px;
  	height: 36px;
  }
  .search_area select{
  	height: 35px;
  }
  #totalTable{
  	
  }
  </style>
</head>
<body>
<div id="totalTable">
	
	<div class="table_wrap">
		<h3>게시판</h3>
		<a href="/board/enroll" class="top_btn">게시글 등록</a>
		<a href="/board/list" class="top_btn">목록</a>
		<table>
			<thead>
				<tr>
					<th class="bno_width">번호</th>
					<th class="title_width">제목</th>
					<th class="writer_width">작성자</th>
					<th class="regdate_width">작성일</th>
					<th class="updatedate_width">수정일</th>
				</tr>
			</thead>
				<c:forEach items="${list }" var="list">
					<tr>
						<td><c:out value="${list.bno}"/></td>
						<td>
							<a class="move" href='<c:out value="${list.bno }"/>'>
								<c:out value="${list.title }"/>
							</a>
						</td>
						<td><c:out value="${list.writer }"/></td>
						<td><fmt:formatDate value="${list.regdate }" pattern="yyyy/MM/dd"/></td>
						<td><fmt:formatDate value="${list.updatedate }" pattern="yyyy/MM/dd"/></td>
					</tr>
				</c:forEach>
		</table>
		
		<div class="search_wrap">
			<div class="search_area">
			<select name="type">
				<option value="" <c:out value="${pageMaker.cri.type == null?'selected':'' }"/>>--</option>
				<option value="T" <c:out value="${pageMaker.cri.type eq 'T'?'selected':'' }"/>>제목</option>
				<option value="C" <c:out value="${pageMaker.cri.type eq 'C'?'selected':'' }"/>>내용</option>
				<option value="W" <c:out value="${pageMaker.cri.type eq 'W'?'selected':'' }"/>>작성자</option>
				<option value="TC" <c:out value="${pageMaker.cri.type eq 'TC'?'selected':'' }"/>>제목 + 내용</option>
				<option value="TW" <c:out value="${pageMaker.cri.type eq 'TW'?'selected':'' }"/>>제목 + 작성자</option>
				<option value="TCW" <c:out value="${pageMaker.cri.type eq 'TCW'?'selected':'' }"/>>제목 + 내용 + 작성자</option>
			</select>
				<input type="text" name="keyword" value="${pageMaker.cri.keyword }">
				<button>검색</button>
			</div>
		</div>
		
		<div class="pageInfo_wrap">
			<div class="pageInfo_area">
				<ul id="pageInfo" class="pageInfo">
				<!-- 이전 페이지 버튼 -->
				<c:if test="${pageMaker.prev }">
					<li class="pageInfo_btn previous"><a href="${pageMaker.startPage-1 }">이전</a></li>
				</c:if>
					<c:forEach var="num" begin="${pageMaker.startPage }" end="${pageMaker.endPage }">
						<li class="pageInfo_btn ${pageMaker.cri.pageNum == num ? "active":"" }"><a href="${num }">${num }</a></li>
					</c:forEach>
				<!-- 다음 페이지 버튼 -->
				<c:if test="${pageMaker.next }">
					<li class="pageInfo_btn next"><a href="${pageMaker.endPage+1 }">다음</a></li>
				</c:if>
				</ul>
			</div>
		</div>
		
		<form action="get" id="moveForm">
		<!-- 페이지 이동할 때 필요 정보인 pageNum과 amount 정보를 전송 -->
			<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum }">
			<input type="hidden" name="amount" value="${pageMaker.cri.amount }">
			<input type="hidden" name="keyword" value="${pageMaker.cri.keyword }">
			<input type="hidden" name="type" value="${pageMaker.cri.type }">
		</form>
	</div>
</div>

<script>
$(document).ready(function(){
	
	let result = '<c:out value="${result}"/>';
	
	checkAlert(result);
	
	function checkAlert(result){
		
		if(result === ''){
			return;
		}
		
		if(result === "enroll success"){
			alert("등록이 완료되었습니다.");
		}
		
		if(result === "modify success"){
			alert("수정이 완료되었습니다.");
		}
		
		if(result === "delete success"){
			alert("삭제가 완료되었습니다.");
		}
		
	}	
	
});


	<!-- 클릭한 <a>태그 기능 정지 -> <form>태그 내부 bno값을 저장하는 <input>태그 생성 -> <form>태그 action 속성 추가 -> <form>태그 내부 데이터 서버 전송 -->
	let moveForm = $("#moveForm");
	
	$(".move").on("click", function(e){
		e.preventDefault();
		
		moveForm.append("<input type='hidden' name='bno' value='" + $(this).attr("href") + "'>");
		moveForm.attr("action", "/board/get");
		moveForm.submit();
	});
	
	$(".pageInfo a").on("click", function(e) {
		/* "a태그 동작 멈춤" =>  
		"<form> 태그 내부 pageNum과 관련된 <input>태그의 vlaue 속성값을 클릭한 <a> 태그의 페이지 번호를 삽입" =>
		"<form>태그 action 속성 추가 및 '/board/list'을 속성값으로 추가" =>
		"<form>태그 서버 전송" */
		
		e.preventDefault();
		moveForm.find("input[name='pageNum']").val($(this).attr("href"));
		moveForm.attr("action", "/board/list");
		moveForm.submit();
		
	});
	
	$(".search_area button").on("click", function(e){
		e.preventDefault();
		
		let type = $(".search_area select").val();
		let keyword = $(".search_area input[name='keyword']").val();
		
		if(!type){
			alert("검색 종류를 선택하세요.");
			return false;
		}
		
		if(!keyword){
			alert("키워드를 입력하세요.");
			return false;
		}
		
		moveForm.find("input[name='type']").val(type);
		moveForm.find("input[name='keyword']").val(keyword);
		moveForm.find("input[name='pageNum']").val(1);
		moveForm.attr("action", "/board/list");
		moveForm.submit();
	});
</script>

</body>
</html>