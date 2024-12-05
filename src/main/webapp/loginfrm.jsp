<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
if('${msg}'!=''){
	alert('${msg}');
}
</script>
</head>
<body>
<h1>loginfrm - 로그인 양식</h1>
   <form action="./login" method = "post">  <!-- post는 보안도 가능하지만 용량이 큰 것도 가능! -->
      아이디 : <input type="text" name="username"><br> 
      비번 : <input type="password" name="userpw"><br>
      <button>로그인</button>
      <a href="./joinfrm.jsp">회원가입</a>
   </form>


</body>
</html>