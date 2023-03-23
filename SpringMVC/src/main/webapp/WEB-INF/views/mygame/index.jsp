<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 9 : 변수 선언-->
<c:url value="/mango/css/mygame.css" var="mygame_css" />
<c:url value="/mango/js/mygame.js" var="mygame_js" />
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Game Index</title>
<!-- 9 -->
<link rel="stylesheet" href="${mygame_css }" />
</head>
<body>

	<h3># 가위바위보 게임</h3>
	<ul>
		<li>처음 접속하는 사용자라면 사용자 이름을 먼저 입력해야 한다. (쿠키 or localStorage)</li>
		<li>이름을 입력하거나 이미 존재하는 이름이 있다면 가위바위보를 계속 진행할 수 있다</li>
		<li>전적은 계속 누적되며 승률도 나오고 나중에 들어와도 유지되어야 한다</li>
	</ul>
	
	<hr>
	
	<!-- 1 -->
	<c:choose>
		<c:when test="${empty cookie.user.value }">
			<!-- 3 -->
			<form action="./index" method="POST">	
				<h4>이름을 설정해주세요</h4>
				<input type="text" name="user" />
				<input type="submit" value="설정" />
			</form>
		</c:when>
		<c:otherwise>
			<!-- 5 -->
			<h3>${cookie.user.value }님의 전적</h3>
			<!-- 19 -->
			<div id="record-panel"></div>
			<!-- 9 -->
			<div id="computer"></div>
			<!-- 15 -->
			<div id="message"></div>
			<div>
				<!-- 7 -->
				<button class="decision" data-num="0">가위</button>
				<button class="decision" data-num="1">바위</button>
				<button class="decision" data-num="2">보</button>
				<!-- 23 -->
				<button id="logout">로그아웃</button>
			</div>
		</c:otherwise>
	</c:choose>
		
		
		<!-- 13 --><!-- 21 -->
		<script>
			const contextPath = '<%=request.getContextPath() %>';
			const userName = '${cookie.user.value}';
		</script>
		
		<!-- 9 -->
		<!-- mango 대신 resources였는데 mango로 바꾼 이유 : mango로 접속하는걸 보여주기 위해 -->
		<script src="${mygame_js }"></script>
</body>
</html>