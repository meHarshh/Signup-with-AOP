<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="saveUser" method="post">
		Enter the user ID:<input type="number" name="userId" /><br>
		Enter the user name:<input type="text" name="userName" /><br>
		Enter the user password:<input type="text" name="userPassword" /><br>
		Confirm the user password:<input type="text" name="confirmPassword" /><br>
		Enter the user Email:<input type="text" name="userEmail" /><br>
		<input type="submit" value="Save">
	</form>

</body>
</html>