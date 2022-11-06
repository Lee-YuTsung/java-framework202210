<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<body>
	<form action="../AddMemberController" method="post">
		<table>
			<tr>
				<td>name:
				<td><input type="text" name="name">
			<tr>
				<td>username:
				<td><input type="text" name="username">
			<tr>
				<td>password:
				<td><input type="password" name="password">
			<tr>
				<td>address:
				<td><input type="text" name="address">
			<tr>
				<td>phone:
				<td><input type="text" name="phone">
			<tr>
				<td>mobile:
				<td><input type="text" name="mobile">
			<tr>
				<td><input type="submit" value="確定">
				<td><input type="reset" value="重填">
		</table>
	</form>
</body>
</html>