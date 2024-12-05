<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>main.jsp</h1>
${logout} <br>
<h1>로그인한 회원정보</h1>
아이디 : ${member.username} <br>
비밀번호 : ${member.userpw } <br>
이름 : ${member.irum} <br>
성별 : ${member.gender} <br>
</body>
</html>