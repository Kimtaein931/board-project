<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>등록페이지입니다.</h1>

<form action="/board/enroll" method="post">
	<div class="input_wrap">
		<label>Title</label>
		<input name="title">
	</div>
	<div class="input_wrap">
		<label>Content</label>
		<input name="Content">
	</div>
	<div class="input_wrap">
		<label>Writer</label>
		<input name="Writer">
	</div>
	<button class="btn">등록</button>
</form>
</body>
</html>