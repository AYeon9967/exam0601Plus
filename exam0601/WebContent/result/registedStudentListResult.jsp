<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList" %>
   <%@ page import="exam.vo.Enroll" %>
   <%@ page import="exam.vo.Subject" %>
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

	<h1>수강생 리스트</h1>
	
	<%
		ArrayList<Subject> list = (ArrayList<Subject>)request.getAttribute("list");
		Subject subject = list.get(0);
	%>
		<p>과목ID: <%= subject.getCount() %>, 과목명:  <%= subject.getProf() %>
		<br>총 수강인원: <%= list.size() %>명</p>
	<%
		if(!list.isEmpty()) { %>
		<table border="1">
		
		<tr><th>학생 id</th><th>이름</th></tr>
		
		<% for(int i=0; i<list.size(); i++) {
			subject = list.get(i); %>
			
			<tr><td><%= subject.getId() %></td>
				<td><%= subject.getName() %></td>

		<%	}
	} else {
		out.print("<h3>No Student</h3>");
	}
	%>
		</table>
		
	<%@ include file="toMenuP.jsp" %>

</body>
</html>