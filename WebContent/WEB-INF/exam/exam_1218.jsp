<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="board.article.ArticleDao"%>
<%@ page import="board.article.Article"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- EL/jstl -->


	h1>EL/JSTL 연습
	</h1>
	<!-- 변수 선언 -->

	<%
	int num = 100;
	%>

	<!-- 변수 출력 -->
	<c:set var="num2" value="10" />
	<%="jps : " + num%><br>

	<!-- JSTL 출력하기 / $ -> EL표시 -->
	<c:out value="JSTL : ${num2}" />
	<br>

	<!-- 조건문 -->
	<%
	num = 10;
	if (num % 2 == 0) {
		out.println("even");
	} else {
		out.println("odd");
	}
	%><br>

	<!-- test에 조건식 / 변수명 구분 잘하기! 자바는 자바 JSTL은 JSTL-->
	<c:if test="${num2 % 2 == 0}">
	even<br>
	</c:if>

	<!-- else if -->
	<c:choose>
		<c:when test="${num2 % 2 == 0}">
			even<br>
		</c:when>
		<c:when test="${num2 % 2 != 0}">
			odd<br>
		</c:when>
	</c:choose>
	
	<!-- else -->
	<c:choose>
		<c:when test="${num2 % 2 == 0}">
			even
		</c:when>
		<c:otherwise>
			odd
		</c:otherwise>
	</c:choose>
	<br>

	<!-- 반복문 -->
	<%
	for (int i = 1; i < 11; i++) {
		out.println(i);
	}
	%><br>
	<!-- var= "변수명", begin="시작값", end="끝값", step="증가량" -->
	<c:forEach var="i" begin="1" end="10" step="1">${i}</c:forEach>
	<br>

	<!-- 문제풀기 -->

	<h1>1 .문제 - 홀수와 짝수 판별</h1>

	<c:set var="num" value="11" />

	<c:choose>
		<c:when test="${num % 2 == 0}">
		even</c:when>
		<c:otherwise>
		odd</c:otherwise>
	</c:choose>

	<h1>2. 문제 - 할인 대상인지 아닌지 출력</h1>

	<c:set var="age" value="30" />

	<c:choose>
		<c:when test="${age <= 19}">
	할인대상입니다.</c:when>
		<c:when test="${age >= 60}">
	할인대상입니다.</c:when>
		<c:otherwise>
	할인대상이 아닙니다.</c:otherwise>
	</c:choose>

	<h1>3. 문제 - 1부터 100까지 수중 짝수만 출력해주세요.</h1>

	<c:forEach var="num2" begin="0" end="100" step="2">
	${num2}
	</c:forEach>

	<h1>4. 문제 - 응용 구구단</h1>
	<c:set var="n" value="4" />
	<c:set var="m" value="19" />
	<c:set var="limit" value="11" />
	<c:forEach var="dan" begin="${n}" end="${m}" step="1">
		<h4>${dan}단</h4>
		<c:forEach var="gugu" begin="2" end="11" step="2">
			<p>${dan}x${gugu} = ${dan * gugu}</p>
		</c:forEach>
	</c:forEach>

	<h1>5. 문제 - 삼각형 그리기1</h1>

	<c:set var="y" value="3" />
	<c:forEach var="i" begin="1" end="${y}">
		<c:forEach var="j" begin="1" end="${i}">
				*
	</c:forEach>
		<br>
	</c:forEach>
	
	<%
		ArrayList<Article> articles = (ArrayList<Article>) request.getAttribute("mydate");
	%>

	<h1>게시판 목록</h1>

	<table border="1" width="500px" hiehgt="150px">
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>내용</td>
			<td>작성자</td>
			<td>조회수</td>
		</tr>
		<%
			for (int i = 0; i < articles.size(); i++) {
				/*for(String str : articles) { 
					out.println(str)
					}*/
				
				// 위와 같은 표현 JSTL <c:forEach var="str" items="${strList}"> ${str}</c:forEach>
		%>
		<tr>

			<td><%=articles.get(i).getArticleNum()%></td>
			<td><%=articles.get(i).getTitle()%></td>
			<td><%=articles.get(i).getBody()%></td>
			<td><%=articles.get(i).getNickname()%></td>
			<td><%=articles.get(i).getHit()%></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>