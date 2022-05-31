<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>회원가입</title>
</head>
<body>
	<form action="join.do" method="post">
		<p>
			아이디:<br /> <input type="text" name="id" value="${param.id}">
			<c:if test="${errors.id}">아이디를 입력하세요.</c:if>
			<c:if test="${errors.duplicateId}">이미 사용중인 아이디입니다.</c:if>
		</p>
		<p>
			비밀번호:<br /> <input type="password" name="password">
			<c:if test="${errors.password}">비밀번호를 입력하세요.</c:if>
		</p>
		<p>
			비밀번호 확인:<br /> <input type="password" name="confirmPassword">
			<c:if test="${errors.notMatch}">입력하신 비밀번호와 일치하지 않습니다.</c:if>
		</p>
		<p>
			닉네임:<br /> <input type="text" name="nickname"
				value="${param.nickname}">
			<c:if test="${errors.nickname}">닉네임을 입력하세요.</c:if>
		</p>
		<input type="submit" value="가입">
	</form>
</body>
</html>