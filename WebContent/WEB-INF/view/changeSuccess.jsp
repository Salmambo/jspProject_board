<%@page import="auth.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>수정 완료</title>
</head>
<body>
	<%
		User user = (User) request.getSession().getAttribute("authUser");
	%>
	<script>
		alert("<%=user.getNickname()%>(<%=user.getId()%>)님, 회원정보를 수정했습니다.");
		location.href = "index.jsp";
	</script>
</body>
</html>