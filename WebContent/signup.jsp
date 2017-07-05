<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
		<li class="active"><a href="#">Create Account</a></li>
		<li><a href="#">Add modules</a></li>
	</ul>

	<div class="signupcontainer">
		<div class="progress">
		  <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width: 0%">
		    <span class="sr-only">0% Complete (success)</span>
		  </div>
		</div>
		<form onsubmit="return checkvalue()" action="InsertLecturerInfoServlet" method="post" class="form-signin">
	        Admission number: <input type="text" name="staffID" id="staffID" class="form-control" placeholder="E.g. S1234567" required autofocus><br>
	        Name: <input type="text" name="staffName" class="form-control" required autofocus><br>
	        Password: <input type="password" name="password" id="password" class="form-control" required autofocus><br>
	        Confirm Password: <input type="password" id="password2" class="form-control" required autofocus><br>
	        <button class="btn btn-primary" id="signupnext" type="submit">Next</button>
	    </form>
	    
	    <%
	    if(session.getAttribute("LECTURER_ID")=="DUPLICATE"){ %>
		<script type="text/javascript">
        	alert('Admission number has been used!');
    	</script>
    	<%
	    }
	    %>
    </div>
    <script type="text/javascript">
		function checkvalue() { 
			var admNo = document.getElementById('staffID').value;
			var pass = document.getElementById('password').value; 
			var pass2 = document.getElementById('password2').value;
			var no = /^[0-9]+$/;
			var alp = /^[a-zA-Z]+$/;
			if (admNo.length != 8) {
				alert('Admission number must be 8 characters long!');
				return false;
			}
			if (pass.length < 8 || pass.length > 16) {
			   	alert ('Password must be of length 8 to 16!');
		    	return false;
			}
			if (!no.test(pass) && !alp.test(pass)) {
			}
			else {
			   	alert ('Password must contain both alphabets and numbers!');
			   	return false;
			}
			if (pass != pass2) {
			   	alert('Password does not match!');
			   	return false;
			}
				    
			return true;
		}
	</script>
			
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="dist/js/bootstrap.min.js"></script>
</body>
</html>