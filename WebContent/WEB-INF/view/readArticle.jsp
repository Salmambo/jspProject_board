<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>게시글</title>
</head>
<body>
	<table>
		<caption>
			<c:out value='${articleData.title}' />
		</caption>
		<thead>
			<tr>
				<th>번호</th>
				<th>작성자</th>
				<th>작성일</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${articleData.number}</td>
				<td>${articleData.writer.nickname}(${articleData.writer.id})</td>
				<td>${articleData.regdate}</td>
			</tr>
			<tr>
				<td colspan="3"><pre>${articleData.content}</pre></td>
			</tr>
		</tbody>
	</table>
	<div>
		<button onclick="location.href='index.jsp';">목록</button>
		<button onclick="location.href='write.do';">작성</button>
		<c:if test="${authUser.id == articleData.writer.id}">
			<button onclick="location.href='modify.do?no=${articleData.number}';">수정</button>
			<button onclick="location.href='delete.do?no=${articleData.number}';">삭제</button>
		</c:if>
	</div>
</body>
</html>