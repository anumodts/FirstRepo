<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- Static content -->
<link rel="stylesheet" href="/resources/css/style.css">


<title>Login</title>
</head>
<body>
	<div class="form">
		<form action="hello" method="post" onsubmit="return validate()">
			<table>
				<tr>
					<td>User name</td>
					<td><input id="name" name="name"></td>
				<tr>
					<td>Password</td>
					<td><input id="password" name="name" type="password"></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Submit"></td>
				</tr>
			</table>
		</form>
		<a href="createUser">Create User</a>
	</div>
<script type="text/javascript" src="/resources/js/app.js"></script>
</body>
</html>