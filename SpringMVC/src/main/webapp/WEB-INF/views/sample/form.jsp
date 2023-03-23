<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>@GetMapping Test</title>
</head>
<body>

	<!-- <h3>get.jsp</h3> -->
	
	<!-- form.jsp -->
	<!-- JSP jstl의 맨 마지막 부분 복습 하세요 -->
	<!-- ContextPath 대신 c:url을 사용한다 -->
	<!-- form action의 ${babo } 부분이 원래 ContextPath방식이었다 -->
	<c:url value="/sample/post" var="form1" />
	<c:url value="/sample/post2" var="form2" />
	<c:url value="/sample/post3" var="form3" />
	
	<!-- form에 있는 name과 SampleController에 있는 변수명이 같아야 자동으로 mapping이 된다. -->
	<h3># Form Test1</h3>
	<form action="${form1 }" method="POST">
		ID: <input type="number" name="employee_id" value="1"><br>
		FIRST_NAME: <input type="text" name="first_name" value="Smith"><br>
		LAST_NAME: <input type="text" name="last_name" value="King"><br>
		<input type="submit" value="OK">
	</form>
	
	<hr>
	
	<h3># Form Test2</h3>
	<!-- form2의 주소는 위의 post2다 -->
	<form action="${form2 }" method="POST">
		ID: <input type="number" name="employee_id" value="2"><br>
		FIRST_NAME: <input type="text" name="first_name" value="Smith"><br>
		LAST_NAME: <input type="text" name="last_name" value="King"><br>
		<input type="submit" value="OK">
	</form>
	
	<hr>
	
	<h3># Form Test3</h3>
	<!-- form3의 주소는 위의 post3다 -->
	<form action="${form3 }" method="POST">
		ID: <input type="number" name="employee_id" value="3"><br>
		FIRST_NAME: <input type="text" name="first_name" value="John"><br>
		LAST_NAME: <input type="text" name="last_name" value="Doe"><br>
		<input type="submit" value="OK">
	</form>

</body>
</html>