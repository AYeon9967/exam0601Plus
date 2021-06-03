<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>교과목 조회</title>
</head>
<body>

	${error }

	<form action="subjectSearch.do" method="post">
		SUBJECT NUMBER : <input type="text" name="id" autofocus><br>
		<input type="submit" value="SEARCH">
	</form>
	
	<%
		String result = (String)request.getAttribute("s");
		if(result != null && result.equals("Yes")) { %>
			<p>
			<form action="enrollment.do" method="post">
				<input type="hidden" name="subId" value="${subject.id }">
				${subject.id }  ${subject.name }	<input type="submit" value="ENROLLMENT"/>
			</form>
		<% 	} else if (result != null && result.equals("No")) {
				out.print("No Subject!!!"); 
			} %>
	
	<%@ include file="result/toMenuS.jsp" %>

</body>
</html>