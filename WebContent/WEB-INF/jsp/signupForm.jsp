<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>회원가입</h1>
	<hr>
	<!-- form은 url제조기 -->
	<!-- action=서버정보 -->
	<form action="/board/member">
		<input type="hidden" name="action" value="signup" />
		<h4>
		아이디
		</h4>
			<input type="text" placeholder="아이디" name="id" />
		<h4>
		비밀번호
		</h4>
			<input type="text" placeholder="비밀번호"  name="pw" />
		<h4>
		이름
		</h4>
			<input type="text" placeholder="닉네임"  name="nm" />
		<br>
		<br>
		<!-- 제출(submit)로 정보를 넘김 -->
		<input type="submit" value="회원가입"/>
	</form>
	<hr>
	<a href="/board/article?action=list">목록으로</a>


</body>
</html>