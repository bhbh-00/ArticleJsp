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

	<h1>게시물 수정</h1>

	<!-- action=서버정보 -->
	<form action="/board/article">
		<input type="hidden" name="action" value="update" /> 
		<input type="hidden" name="mid" value="${ mydate3.articleNum }" /><br> 
		번호 : ${ mydate3.articleNum } <br>
		제목 : <input type="text" name="title" value="${ mydate3.title }"/> <br> 
		내용 : <input type="text" name="body" value="${ mydate3.body }"/> <br> 
		<input type="submit" />
	</form>

</body>
</html>