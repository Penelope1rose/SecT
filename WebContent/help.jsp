<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Secured-T</title>

    <!-- Bootstrap core CSS -->
    <link href="dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/signup.css" rel="stylesheet">
    
    <!-- Favicon -->
	<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
	<link rel="icon" href="images/favicon.ico" type="image/x-icon">
	
</head>
<body>

	<h2 id="featuresheader">Features</h2>

	<div class="featurescontainer">
		<p>
		<b>Congratulations on creating an account! Below are some of the things you can do:</b><br><br>
		- Lecturer can view, add and delete modules<br>
		- Lecturer can add and delete assessments, view upcoming and all assessments<br>
		- Lecturer can start an assessment to view details and status of students and end an assessment<br>
		- Lecturer can remove disconnected computers<br>
		- Lecturer can demand student logging (SS & KL) from connected computers<br>
		- Lecturer can add, view and search the announcements<br><br>
		<p id="imptmessage"><b>Do be aware that the staff number is unique. You are not allowed to create another account with the same staff number. Keep your account information where you will not lose it.</b></p><br>
		<b>For more detailed explanation on what you can do in this website, proceed to 'help' under your account.</b><br>
		</p><br>
		<form action="index.jsp" class="form-signin">
	        <button class="btn btn-primary" id="login" type="submit">Proceed to Login</button>
	    </form>
    </div>
	
	<div id="space"></div>
    <footer class="footer">
	   <p id="copyright">&copy; 2017 Singapore Polytechnic (DISM/FT/3A/62)</p>
	</footer>
			
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="dist/js/bootstrap.min.js"></script>
</body>
</html>