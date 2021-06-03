<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>

<h3>YongIn LMS Login</h3>

	${error }

	<form action="login.do" method="post">
		ID: <input type="text" name="id"/><br>
		PASSWORD: <input type="password" name="pwd"/><br>
			<label><input type="radio" name="position" value="professor">Professor</label>
			<label><input type="radio" name="position" value="student">Student</label><br>
		<input type="submit" value="LOGIN"/>
	</form>


</body>
</html>