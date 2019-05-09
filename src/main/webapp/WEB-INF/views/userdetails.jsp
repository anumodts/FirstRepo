<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Details Page</title>
</head>
<link rel="stylesheet" href="/resources/css/registerform.css">
<body>
<h1>Register</h1>
    <p>Please fill in this form to create an account.</p>
    <hr>
	<div class="container">
		<form action="saveuser" method="post" id="userdetails-form">

			
					<b>User name</b>
					<br>
					<input id="username" name="username" type="text" placeholder="Enter user name">
					<br>
					<div class="userexistmessage" id="feedback" ></div>
				
					<b>Password</b>
					<br>
					<input id="password" name="password" type="password" placeholder="Enter Password">
					<br>
				
					<b>First Name</b>
					<br>
					<input id="firstname" name="firstname" type="text" placeholder="Enter First Name">
					<br>
				
				
					<b>Last Name</b>
					<br>
					<input id="lastname" name="lastname" type="text" placeholder="Enter Last Name">
					<br>
				
					<b>Phone Number</b>
					<br>
					<input id="phone" name="phone" type="text" placeholder="Enter Phone Number">
					<br>
			
					<b>Email id</b>
					<br>
					<input id="emailid" name="emailid" type="text" placeholder="Enter Email Id">
					<br>
				
					
					<button type="submit" id="registerbtn" class="registerbtn">Register</button>
					
					

		</form>
	</div>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="/resources/js/main.js"></script>
</body>
</html>