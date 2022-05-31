<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	session.invalidate();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>탈퇴 완료</title>
</head>
<body>
	<script>
		alert("탈퇴되었습니다.");
		location.href = "index.jsp";
	</script>
</body>
</html>