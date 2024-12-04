<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>joinfrm.jsp - 회원가입 양식</h1>
<form action="./join" method="post">
	아디: 	<input type="text" name="username">
			<br>
			
	비번: 	<input type="password" name="userpw">
		 	<br>
		 	
	이름: 	<input type="text" name="irum">
		 	<br>
		 	
	성별: 	<input type="radio" name="gender" value="남자">남자
		 	<input type="radio" name="gender" value="여자" checked>여자
		 	<br>
		 	
		 	<button>회원가입</button>
		 	<button type="reset">취소</button>
</form>
</body>
</html>