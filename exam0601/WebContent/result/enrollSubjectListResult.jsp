<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="java.util.ArrayList" %>
   <%@ page import="exam.vo.Subject" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>교수: 등록한 과목 리스트</title>
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
	<h1>등록한 과목 리스트</h1>

	<%
		ArrayList<Subject> list = (ArrayList<Subject>)request.getAttribute("list");
		if(!list.isEmpty()) { %>
		<table border="1">
		
		<tr><th>과목번호</th><th>과목명</th><th>최대인원</th><th>수강인원</th></tr>
		
		<% for(int i=0; i<list.size(); i++) {
			Subject subject = list.get(i); %>
			
			<tr><td><a href="/exam0601/registedStu.do?num=<%=subject.getId()%>"><%=subject.getId()%></a></td>
				<td><%= subject.getName() %></td>
				<td><%= subject.getCount() %></td>
				<td><%= subject.getProf() %></td>

		<%	}
	} else {
		out.print("<h3>No enroll Subject</h3>");
	}
	%>
		</table>
		
	<%@ include file="toMenuP.jsp" %>

</body>
</html>