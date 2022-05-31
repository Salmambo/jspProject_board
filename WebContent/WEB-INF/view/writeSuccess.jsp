<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>등록 완료</title>
</head>
<body>
	${ctxPath = pageContext.request.contextPath ; ''}
	<script>
		alert("게시글을 등록했습니다.");
		location.href = "${ctxPath}/read.do?no=${newArticleNo}";
	</script>
</body>
</html>