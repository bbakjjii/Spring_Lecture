<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 목록</title>
</head>
<body>

	<!-- 연습문제 : 강사님 정답 -->
	<div>
		<c:forEach items="${boards}" var="board">
			<div>${board}</div>
			<div><a href="./modify?board_id=${board.board_id}&write_title=테스트하기 test&write_content=시험용테스트">수정</a></div>
			<div><a href="./delete?board_id=${board.board_id}">삭제</a></div>
		</c:forEach>
	</div>

</body>
</html>