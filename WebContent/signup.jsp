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

	<h2 id="signupheader">Create Account</h2>

	<div class="signupcontainer">
		<form onsubmit="return checkvalue()" action="InsertLecturerInfoServlet" method="post" class="form-signin">
	        Staff number: <input type="text" name="staffID" id="staffID" class="form-control" placeholder="E.g. S1234567" required autofocus><br>
	        Name: <input type="text" name="staffName" class="form-control" required autofocus><br>
	        Password: <input type="password" name="password" id="password" class="form-control" required autofocus><br>
	        Confirm Password: <input type="password" id="password2" class="form-control" required autofocus><br>
	        <button class="btn btn-primary" id="signupnext" type="submit">Next</button>
	    </form>
	    
	    <%
	    if(session.getAttribute("LECTURER_ID")=="DUPLICATE"){ %>
		<script type="text/javascript">
        	alert('Staff number has been used!');
    	</script>
    	<%
	    }
	    %>
    </div>
    
    <div id="space"></div>
    <footer class="footer">
	   <p id="copyright">&copy; 2017 Singapore Polytechnic (DISM/FT/3A/62)</p>
	</footer>
	
    <script type="text/javascript">
		function checkvalue() { 
			var staffID = document.getElementById('staffID').value;
			var pass = document.getElementById('password').value; 
			var pass2 = document.getElementById('password2').value;
			var no = /^[0-9]+$/;
			var alp = /^[a-zA-Z]+$/;
			if (staffID.length > 8) {
				alert('Staff number must not be more than 8 characters long!');
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