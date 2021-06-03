<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>교수: 과목등록</title>
</head>
<body>

	${error }
	<form action="insertSubject.do" method="post">
		<h3>Subject</h3>
		ID: <input type="text" name="id" autofocus> <br>
		TITLE: <input type="text" name="title"> <br>
		# of Student: <input type="text" name="sn"> <br>
		<input type="submit" value="ENROLL">
	</form>

</body>
</html>