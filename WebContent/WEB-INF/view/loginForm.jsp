<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>로그인</title>
</head>
<body>
	<form action="login.do" method="post">
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
		<input type="submit" value="로그인">
	</form>
</body>
</html>