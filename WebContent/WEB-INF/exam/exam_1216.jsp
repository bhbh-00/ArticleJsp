<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="board.article.Article"%>
<%@ page import="board.article.ArticleDao"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- # JSP 작성법

    1. 스크립틀릿 : <%-- 자바 코드 --%>
    2. 표현식 : <%-- PrintWriter의 println() 기능을 수행 --%>
    3. 선언문 : <%--메서드 선언 선언--%>
    4. 주석 : <%-- 주석문 --%>
    5. 지시자 : <%--특별지시코드(page, include, taglib) --%>

    # JSP 주요 내장객체

    1. request 객체 : 요청에 관한 정보 및 기능
    2. response 객체 : 응답에 관한 정보 및 기능
    3. session 객체 : 세션에 관한 정보 및 기능(세션이란 일정한 연결을 유지하는 단위)
    4. out 객체 : PrintWriter 객체. 브라우저에 출력 기능
     -->
     
     	<%
		ArticleDao ADao = new ArticleDao();

		ArrayList<Article> articles = ADao.getArticles();
	%>
	
	<h2>게시판 목록</h2>
	
	<table border="1" width="500px" hiehgt="150px">
	<tr>
	<td>번호</td>
	<td>제목</td>
	<td>내용</td>
	<td>작성자</td>
	<td>조회수</td>
	</tr>
	<% for(int i = 0; i < articles.size(); i++) {%>
	<tr>
	<td><%= articles.get(i).getArticleNum()%></td>
	<td><%= articles.get(i).getTitle()%></td>
	<td><%= articles.get(i).getBody()%></td>
	<td><%= articles.get(i).getNickname()%></td>
	<td><%= articles.get(i).getHit()%></td>
	</tr>
	<% } %>
	</table>

</body>
</html>