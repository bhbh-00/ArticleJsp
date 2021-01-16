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
	<h1>게시물등록</h1>
	
	<!-- form은 url제조기 -->	
	<!-- action=서버정보 -->
	<form action="/board/article">
		<input type="hidden" name="action" value="insert" /> 
		제목 : <input type="text" name="title" /> 
		<br>
		내용 : <input type="text"	 name="body" />
		<br>
		<input type="hidden" name="id" value="${loginedMember.memberRegNum}"/> 
		<br>
		<!-- 제출(submit)로 정보를 넘김 -->
		<input type="submit" value="등록"/>
	</form>
	
</body>
</html>