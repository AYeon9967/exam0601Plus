<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList" %>
   <%@ page import="exam.vo.Enroll" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생: 수강신청한 과목 리스트</title>
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

	<h3>수강신청한 과목 리스트</h3>

	<%
		ArrayList<Enroll> list = (ArrayList<Enroll>)request.getAttribute("list");
		if(!list.isEmpty()) { %>
		<table border="1">
		
		<tr><th>과목번호</th><th>과목명</th></tr>
		
		<% for(int i=0; i<list.size(); i++) {
			Enroll enroll = list.get(i); %>
			
			<tr><td><%= enroll.getSubject() %></td>
				<td><%= enroll.getStudent() %></td>

		<%	}
	} else {
		out.print("<h3>No enroll Subject</h3>");
	}
	%>
		</table>
		
	<%@ include file="toMenuS.jsp" %>

</body>
</html>