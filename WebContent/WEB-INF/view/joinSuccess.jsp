<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>가입 완료</title>
</head>
<body>
	<script>
		alert("${param.nickname}(${param.id})님, 회원가입에 성공했습니다.");
		location.href = "index.jsp";
	</script>
</body>
</html>