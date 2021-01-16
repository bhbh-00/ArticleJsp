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

<c:forEach var="reply" items="${replies}">
		<c:choose>
			<c:when test="${flag == 'u' && rid = reply.replyId }">
				<p>닉네임 : ${loginedMember.membernickname}</p>
				<form action="/board/article">
					<input type="text" name="rbody" value="${reply.replybody}" />
					<input type="hidden" name="rid" value="${reply.replyId}" />
					<input type="hidden" name="aid" value="${mydate2.articleNum}" />
					<input type="hidden" name="action" value="doUpdateReply" />
					<input type="submit" value="등록" />
				</form>
			</c:when>
			<c:otherwise>
				<p>${reply.replynickname}</p>
				<br>
				<p>${reply.replybody}</p>
				<br>
				<p>${reply.replyregdate}</p>
				<br>
				<c:if test="${reply.mid == loginedMember.memberRegNum}">
					<a href="/board/article?action=showReplyUpdate&rid=${reply.replyId}&aid=${ mydate2.articleNum }">수정</a>
					<a
						href="/board/article?action=deletReply&rid=${reply.replyId}&aid=${ mydate2.articleNum }">삭제</a>
				</c:if>
				<hr>
			</c:otherwise>
		</c:choose>
	</c:forEach>
<h3>댓글</h3>
	<hr>
	<p>닉네임 : ${loginedMember.membernickname}</p>
	<form action="/board/article">
		<input type="text" name="rbody" placeholder="댓글을 입력해주세요." /> <input
			type="hidden" name="action" value="doInsertReply" /> <input
			type="hidden" name="aid" value="${mydate2.articleNum}" /> <input
			type="hidden" name="mid" value="${loginedMember.memberRegNum}" /> <input
			type="submit" value="등록" />
	</form>
	<hr>

</body>
</html>