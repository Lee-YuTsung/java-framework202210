<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"
    import="Model.Member"%>
<%
	Member m = (Member)session.getAttribute("M");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<body>
	<h2>歡迎<%=m.getUserName() %>加入會員</h2>
	<a href="../porder/index">進入購物</a>
</body>
</html>