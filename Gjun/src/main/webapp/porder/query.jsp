<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"
    import="Dao.Porder.PorderDaoImpl"
    import="java.util.List"
    import="Model.Porder"%>
    
 <%
 //String show1=new PorderDaoImpl().queryAll1() ;
// List<porder> l=new porderDao().queryAll2();
 //List<porder> l=new porderDao().querySum(1600, 2200);
 /*
 1.request-->接收判斷-->null ,""
 2.有--->l=querySum
 3.null,""-->l=queryAll2
 
 */
 String Start=request.getParameter("start");
 String End=request.getParameter("end");
 List<Porder> l=null;
 if(Start!=null && Start!="" && End!=null && End!="")
 {
	int S=Integer.parseInt(Start);
	int E=Integer.parseInt(End);
	
	l=new PorderDaoImpl().querySum(S, E);
 }
 else
 {
	 l=new PorderDaoImpl().queryAll();
 }
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<body>
<table width=600 align=center border=1>
		<tr height=100>
			<td align=center><jsp:include page="title.jsp"/>
		<tr height=450>
			<td >
			<form action="query.jsp">
				<table width=500 align=center border=1>
					<tr>
						<td>訂單資料
					<tr>
						<td>
						輸入金額:
						從<input type="text" name="start" size=5>到<input type="text" name="end" size=5>
						<input type="submit" value="確定">					
						
				</table>
			</form>
			<hr>
			<table width=500 align=center border=1>
			<tr>
				<td>ID<td>桌號<td>A餐<td>B餐<td>C餐<td>金額
			<%
				for(Porder p:l)
				{
					out.println("<tr><td>"+p.getId()+
							"<td>"+p.getDesk()+
							"<td>"+p.getA()+
							"<td>"+p.getB()+
							"<td>"+p.getC()+
							"<td>"+p.getSum());
				}
			
			
			%>
			<tr>
				<td colspan=6 align=center>
				<a href="index.jsp">回首頁</a>
			</table>
			
			
			
			
			
		<tr height=50>
			<td align=center><jsp:include page="footer.jsp"/>
	
	</table>

</body>
</html>