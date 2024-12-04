<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>joinfrm.jsp</h1>
<form action="./join" method="post">
	<input type="text" placeholder="아이디" name="username"/>
	<input type="text" placeholder="비번" name="userpw" />
	<input type="text" placeholder="이름" name="name" />
	<input type="radio" placeholder="성별" name="gender" value="남자"/>
	<input type="radio" placeholder="성별" name="gender" value="여자"/>
	<button>회원가입</button>
	<button type="reset">취소</button> 
</form>
</body>
</html>