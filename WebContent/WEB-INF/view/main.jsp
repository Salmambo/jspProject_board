<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
	<div>
		<c:if test="${empty authUser }">
			<button onclick="location.href='login.do';">로그인</button>
			<button onclick="location.href='join.do';">회원가입</button>
		</c:if>
		<c:if test="${! empty authUser }">
			<button onclick="location.href='logout.do';">로그아웃</button>
			<button onclick="location.href='change.do';">회원정보수정</button>
			<button onclick="location.href='resign.do';">회원탈퇴</button>
		</c:if>
	</div>
	<table>
		<caption>게시판</caption>
		<thead>
			<tr>
				<td><button onclick="location.href='write.do';">작성</button></td>
			</tr>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${articlePage.hasNoArticles()}">
				<tr>
					<td colspan="4">게시글이 없습니다.</td>
				</tr>
			</c:if>
			<c:forEach var="article" items="${articlePage.content}">
				<tr>
					<td>${article.number}</td>
					<td><a
						href="read.do?no=${article.number}&pageNo=${articlePage.currentPage}">
							<c:out value="${article.title}" />
					</a></td>
					<td>${article.writer.nickname}(${article.writer.id })</td>
					<td>${article.regdate}</td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<c:if test="${articlePage.hasArticles()}">
				<tr>
					<td><c:if test="${articlePage.startPage > 5}">
							<a href="list.do?pageNo=${articlePage.startPage - 5}">[이전]</a>
						</c:if></td>
					<td colspan="2"><c:forEach var="pNo"
							begin="${articlePage.startPage}" end="${articlePage.endPage}">
							<a href="list.do?pageNo=${pNo}">[${pNo}]</a>
						</c:forEach></td>
					<td><c:if
							test="${articlePage.endPage < articlePage.totalPages}">
							<a href="list.do?pageNo=${articlePage.startPage + 5}">[다음]</a>
						</c:if></td>
				</tr>
			</c:if>
		</tfoot>
	</table>
</body>
</html>