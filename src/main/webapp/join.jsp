<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입을 시작하자!</h1>
	<form action="join" method = "post">
	아이디 : <input type = "text" name = "username"><br>
	비번 : <input type = "password" name = "userpw"><br>
	이름 : <input type = "text" name = "name"><br>
	성별 : <input type = "radio" name = "gender" value = "male">남자
		<input type = "radio" name = "gender" value = "female">여자<br>
	<button>회원가입</button>
	<button type = "reset">취소</button>
	</form>

</body>
</html>