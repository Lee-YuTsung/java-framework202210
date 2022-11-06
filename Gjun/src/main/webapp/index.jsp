<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<body>
	
	<form action="LoginController" method="post">
		username:<input type="text" name="username"><br>
		password:<input type="password" name="password"><br>
		<input type="submit" value="登入">
	</form>
	<a href="member/addMember.jsp">加入會員</a>
	<%
		session.removeAttribute("M");
	%>
</body>
</html>