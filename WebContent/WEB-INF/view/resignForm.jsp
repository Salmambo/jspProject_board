<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>회원탈퇴</title>
</head>
<body>
	<form action="resign.do" method="post">
		<h3>회원탈퇴를 위해 아이디와 비밀번호를 재입력 해주세요.</h3>
		<c:if test="${errors.idOrPwNotMatch}">
			<p>아이디 혹은 비밀번호가 일치하지 않습니다.</p>
		</c:if>
		<p>
			아이디:<br /> <input type="text" name="id" value="${param.id}">
			<c:if test="${errors.id}">아이디를 입력하세요.</c:if>
		</p>
		<p>
			비밀번호:<br /> <input type="password" name="password">
			<c:if test="${errors.password}">비밀번호를 입력하세요.</c:if>
		</p>
		<input type="submit" value="회원탈퇴">
	</form>
</body>
</html>