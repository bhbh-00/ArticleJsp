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
	<h1>LOGIN</h1>
	<a href="/board/member?action=showSignup">회원가입</a>
	<a href="/board/article?action=list">목록으로</a>
	<hr>
	<!-- form은 url제조기 -->
	<!-- action=서버정보 -->
	<form action="/board/member">
		<input type="hidden" name="action" value="signin" />
		<h4>
			<input type="text" name="loginid" placeholder="아이디" />
		</h4>
		<h4>
			<input type="text" name="loginpw" placeholder="비밀번호" />
		</h4>
		<br>
		<!-- 제출(submit)로 정보를 넘김 -->
		<input type="submit" value="로그인" />
	</form>

</body>
</html>