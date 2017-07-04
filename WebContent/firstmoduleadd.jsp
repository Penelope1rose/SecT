<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,java.util.*,db.*,controller.*,model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Secured-T Sign-up</title>

    <!-- Bootstrap core CSS -->
    <link href="dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/signup.css" rel="stylesheet">
    
    <!-- Favicon -->
	<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
	<link rel="icon" href="images/favicon.ico" type="image/x-icon">
	
</head>
<body>

	<ul class="nav nav-pills" id="signupbar">
		<li id="signupnav"><a href="#">Create Account</a></li>
		<li class="active" id="signupnav2"><a href="#">Add modules</a></li>
	</ul>
	<div class="signupcontainer">
		<div class="progress">
		  <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100" style="width: 50%">
		    <span class="sr-only">50% Complete (success)</span>
		  </div>
		</div>
		<form action="home.jsp">
			Module Name: <input type="text" name="modName" class="form-control" required autofocus><br>
	        Module Code: <input type="text" name="modCode" class="form-control" required autofocus><br>
	        <a href="index.jsp">Add later (login)</a>
		    <button class="btn btn-primary" id="signupnext" type="submit">Finish</button>
		</form>
	</div>


</body>
</html>