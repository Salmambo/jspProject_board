<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>회원정보수정</title>
</head>
<body>
	<form action="change.do" method="post">
		<p>
			닉네임:<br /> <input type="text" name="nickname"
				value="${authUser.getNickname()}">
			<c:if test="${errors.nickname}">닉네임을 입력하세요.</c:if>
		</p>
		<p>
			현재 비밀번호:<br /> <input type="password" name="curPwd">
			<c:if test="${errors.curPwd}">비밀번호를 입력하세요.</c:if>
			<c:if test="${errors.badCurPwd}">비밀번호가 일치하지 않습니다.</c:if>
		</p>
		<p>
			신규 비밀번호:<br /> <input type="password" name="newPwd">
			<c:if test="${errors.newPwd}">비밀번호를 입력하세요.</c:if>
			<c:if test="${errors.samePassword}">같은 비밀번호로 변경할 수 없습니다.</c:if>
		</p>
		<p>
			신규 비밀번호 확인:<br /> <input type="password" name="confirmPassword">
			<c:if test="${errors.notMatch}">입력하신 비밀번호와 일치하지 않습니다.</c:if>
		</p>
		<input type="submit" value="회원정보수정">
	</form>
</body>
</html>