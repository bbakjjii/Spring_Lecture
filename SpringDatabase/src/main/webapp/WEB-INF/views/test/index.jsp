<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<ul>
		<li><a href="./employees">employees 보러가기</a></li>
		<li><a href="./employees2">employees 보러가기 (Mybatis)</a></li>
		<li><a href="./board/get?board_id=1">글 하나 보기 (Mybatis)</a></li>
		<li><a href="./board/add?write_id=mybatis&write_pw=4321&write_title=Mybatis Test&write_content=hello!!">글 쓰기 (Mybatis)</a></li>		
		<li><a href="./board/update?write_title=안녕하계세요여러분&write_content=안녕히계세요&board_id=3">글 수정 (Mybatis)</a></li>	
		<li><a href="./board/delete?board_id=3">글 삭제 (Mybatis)</a></li>
		
		<li><a href="./board/list">글 전체 목록 보기</a></li>
	</ul>
	
</body>
</html>