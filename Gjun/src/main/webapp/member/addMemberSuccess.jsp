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
	<h2>�w��<%=m.getUserName() %>�[�J�|��</h2>
	<a href="../porder/index">�i�J�ʪ�</a>
</body>
</html>