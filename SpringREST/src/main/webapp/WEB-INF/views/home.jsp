<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rest 요청 보내보기</title>
</head>
<body>

	<!-- 8 -->
	<h3>Rest 요청 보내보기</h3>
	<ul>
		<li><a href="/springrest/restful/test1">Hello</a></li>
		<li><a href="/springrest/restful/pizza1">pizza1(JSON, 수동)</a></li>
		<li><a href="/springrest/restful/pizza2">pizza2(JSON, 자동)</a></li>
		<li><a href="/springrest/restful/pizza3">pizza3(XML)</a></li> <!-- 11 -->
	</ul>
	
	<h3># ResponseEntity로 원하는 응답 직접 생성하기</h3>
	<ul>
	<li><a href="/springrest/restful/ok1">ok1</a></li>
	<li><a href="/springrest/restful/ok2">ok2</a></li>
	<li><a href="/springrest/restful/ok3">ok3</a></li>
	<li><a href="/springrest/restful/status1">status1 (502 Bad Gateway)</a></li>
	<li><a href="/springrest/restful/status2">status2 (404 Not found)</a></li>
	</ul>
	
	<!-- 27 -->
	<h3># AJAX 요청 보내기 (GET)</h3>
	<c:url value = "/resources/js/home.js" var="home_js" />
	
	<div id="ajax-out" style="border: solid 1px black;"></div>
	
	<button id="ajax-btn1">AJAX1(GET Plain Text)</button>
	<button id="ajax-btn2">AJAX2(GET JSON Text)</button> <!-- 29 -->
	<button id="ajax-btn3">AJAX3(GET XML Text)</button> <!-- 32 -->
	
	<!-- 35 -->
	<h3># AJAX 요청 보내기 (POST)</h3>
	<button id="ajax-post-btn1">AJAX1(POST, Form)</button>
	<button id="ajax-post-btn2">AJAX2(POST, JSON)</button><!-- 39 -->
	
	<!-- 39 -->
	<h3># AJAX 요청 보내기 (PUT)</h3>
	<button id="ajax-put-btn1">AJAX1(PUT, JSON)</button>
	<button id="ajax-put-btn2">AJAX2(PUT, 연습)</button><!-- 42 -->
	
	<!-- 24 -->
	<h3># Form 방식으로 요청 보내기</h3>
	<c:url value="/restful/employee" var="emp" />

	<h5>* Post(form)</h5>
	<form action="${emp }" method="POST">
		<input type="hidden" name="first_name" value="Mike" />
		<input type="hidden" name="last_name" value="Park" />
		<input type="hidden" name="salary" value="5500" />
		<input type="submit" value="보내기(POST)"/>
	</form>
	
	<!-- 25 -->
	<h5>* Put(form)</h5>
	<p><i>form으로는 GET방식과 POST방식 요청만 보낼 수 있다</i></p>
	<form action="${emp }" method="PUT">
		<input type="hidden" name="first_name" value="Smith" />
		<input type="hidden" name="last_name" value="King" />
		<input type="hidden" name="salary" value="11000" />
		<input type="submit" value="보내기(PUT)"/>
	</form>
	
	<!-- 27 -->
	<script src="${home_js}"></script>
</body>
</html>