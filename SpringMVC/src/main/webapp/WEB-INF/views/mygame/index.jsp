<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 9 : ���� ����-->
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

	<h3># ���������� ����</h3>
	<ul>
		<li>ó�� �����ϴ� ����ڶ�� ����� �̸��� ���� �Է��ؾ� �Ѵ�. (��Ű or localStorage)</li>
		<li>�̸��� �Է��ϰų� �̹� �����ϴ� �̸��� �ִٸ� ������������ ��� ������ �� �ִ�</li>
		<li>������ ��� �����Ǹ� �·��� ������ ���߿� ���͵� �����Ǿ�� �Ѵ�</li>
	</ul>
	
	<hr>
	
	<!-- 1 -->
	<c:choose>
		<c:when test="${empty cookie.user.value }">
			<!-- 3 -->
			<form action="./index" method="POST">	
				<h4>�̸��� �������ּ���</h4>
				<input type="text" name="user" />
				<input type="submit" value="����" />
			</form>
		</c:when>
		<c:otherwise>
			<!-- 5 -->
			<h3>${cookie.user.value }���� ����</h3>
			<!-- 19 -->
			<div id="record-panel"></div>
			<!-- 9 -->
			<div id="computer"></div>
			<!-- 15 -->
			<div id="message"></div>
			<div>
				<!-- 7 -->
				<button class="decision" data-num="0">����</button>
				<button class="decision" data-num="1">����</button>
				<button class="decision" data-num="2">��</button>
				<!-- 23 -->
				<button id="logout">�α׾ƿ�</button>
			</div>
		</c:otherwise>
	</c:choose>
		
		
		<!-- 13 --><!-- 21 -->
		<script>
			const contextPath = '<%=request.getContextPath() %>';
			const userName = '${cookie.user.value}';
		</script>
		
		<!-- 9 -->
		<!-- mango ��� resources���µ� mango�� �ٲ� ���� : mango�� �����ϴ°� �����ֱ� ���� -->
		<script src="${mygame_js }"></script>
</body>
</html>