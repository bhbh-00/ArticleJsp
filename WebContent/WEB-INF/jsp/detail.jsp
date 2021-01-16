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
	
	<h1>게시물 상세보기</h1>
	<a href="/board/article?action=list">목록으로</a>
	<c:if test="${mydate2.nickname == loginedMember.membernickname}">
		<a href="/board/article?action=showUpdate&aid=${ mydate2.articleNum }">수정</a>
		<a href="/board/article?action=delete&aid=${ mydate2.articleNum }">삭제</a>
	</c:if>

	<hr>
	<h4>번호</h4>
	<p>${ mydate2.articleNum }</p>
	<hr>
	<h4>제목</h4>
	<p>${ mydate2.title }</p>
	<hr>
	<h4>내용</h4>
	<p>${ mydate2.body }</p>
	<hr>
	<!-- 좋아요 -->
	<a href="/board/article?dolike&aid=${ mydate2.articleNum }">좋아요</a> ${ mydate2.likeCnt }
	<!-- 댓글 기능 -->



</body>
</html>