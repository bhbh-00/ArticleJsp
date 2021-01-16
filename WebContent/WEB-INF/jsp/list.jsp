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

	<h1>게시물목록</h1>

	<c:choose>
		<c:when test="${loginedMember != null}">
			<h4>${loginedMember.membernickname}님,반갑습니다!</h4>
			<a href="/board/member?action=showLogout">로그아웃</a>
		</c:when>
		<c:otherwise>
			<a href="/board/member?action=showSignup">회원가입</a>
			<a href="/board/member?action=showSignin">로그인</a>
		</c:otherwise>
	</c:choose>

	<hr>
	<br>
	<table border="1" width="500px">
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>조회수</td>
		</tr>

		<c:forEach var="article" items="${mydate}">
			<tr>
				<td>${article.articleNum}</td>
				<td><c:choose>
						<c:when test="${loginedMember == null}">
							<a href="/board/member?action=showSignin">${article.title}_${article.articleNum}</a>
						</c:when>
						<c:otherwise>
							<a href="/board/article?action=detail&aid=${article.articleNum}">${article.title}_${article.articleNum}</a>
						</c:otherwise>
					</c:choose></td>
				<td>${article.nickname}</td>
				<td>${article.hit}</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<hr>

	<c:if test="${loginedMember != null}">
		<a href="/board/article?action=showAdd">글쓰기</a>
	</c:if>
	<hr>

	<!-- 페이징 -->
	<c:forEach begin="1" end="10" var="i">
		<a href="/board/member?action=list">${ i }</a>
	</c:forEach>
	<hr>
	<!-- 검색기능 -->
	<form action="/board/article">
		<!-- 기간 검색 1일, 1주일, 1달, 6개월, 1년 -->
		<select name="date">
			<option value="all">전체기간</option>
			<option value="-1 day">1일</option>
			<option value="-1 week">1주일</option>
			<option value="-1 month">1달</option>
			<option value="-6 month">6개월</option>
			<option value="-1 year">1년</option>
		</select>
		<!-- 검색기준 제목, 제목 + 내용, 작성자, 댓글내용, 댓글 작성자 -->
		<select name="Target">
			<option value="title">제목</option>
			<option value="title&body">제목 + 내용</option>
			<option value="nickname">작성자</option>
			<option value="replybody">댓글내용</option>
			<option value="replynickname">댓글작성자</option>
		</select> <input type="text" name="keyword" placeholder="검색내용을 입력해주세요." /> <input
			type="hidden" name="action" value="doSearch" /> <input type="submit"
			value="검색" />
	</form>

	<!-- 정렬 조회수기준 좋아요기준 -->



</body>
</html>