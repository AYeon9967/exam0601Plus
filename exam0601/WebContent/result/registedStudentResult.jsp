<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList" %>
   <%@ page import="exam.vo.Enroll" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>교수: 과목의 수강생 리스트</title>
</head>
<style>
tr {
	text-align: center;
}
td {
	width: 150px;
	padding: 3px;
}
</style>
<body>

	<h3>수강생 리스트</h3>

	<%
		ArrayList<Enroll> list = (ArrayList<Enroll>)request.getAttribute("list");
		if(!list.isEmpty()) { %>
		<table border="1">
		
		<tr><th>학생 id</th><th>이름</th></tr>
		
		<% for(int i=0; i<list.size(); i++) {
			Enroll enroll = list.get(i); %>
			
			<tr><td><%= enroll.getSubject() %></td>
				<td><%= enroll.getStudent() %></td>

		<%	}
	} else {
		out.print("<h3>No Student</h3>");
	}
	%>
		</table>
		
	<%@ include file="toMenuP.jsp" %>

</body>
</html>