<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,java.util.*,db.*,controller.*,model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Secured-T</title>

	<!-- JS -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    
    <!-- Bootstrap core CSS -->
    <link href="dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <!-- Custom styles for this template -->
    <link href="css/home.css" rel="stylesheet">
    
    <!-- Favicon -->
	<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
	<link rel="icon" href="images/favicon.ico" type="image/x-icon">
	
	<%
		if(session.getAttribute("LOGIN") != "TRUE") {
			response.sendRedirect("index.jsp");
		}
	%> 
</head>
<body>
  <%
	ArrayList<LecturerInfoDetails> retrieveLecturerInfo = (ArrayList<LecturerInfoDetails>)session.getAttribute("lecturer");

	if (retrieveLecturerInfo != null) {
		for(LecturerInfoDetails lecturer:retrieveLecturerInfo) {
		%>
    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <a class="navbar-brand" id="homenav" href="RetrieveAssessmentInfoServlet?staffID=<%=lecturer.getStaffNumber()%>"><img src="images/logo.png" alt="Secured-T logo" id="logo">Secured-T</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li class="dropdown">
	          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><span class="glyphicon glyphicon-user" aria-hidden="true"></span>&nbsp;<%=lecturer.getStaffName()%>&nbsp;<span class="caret"></span></a>
	          <ul class="dropdown-menu">
	            <li><a href="profile.jsp">Profile</a></li>
	            <li><a href="detailedhelp.jsp">Help</a></li>
	            <li><a href="LogoutServlet">Log out</a></li>
	          </ul>
	        </li>
          </ul>
        </div>
      </div>
    </nav>

	<h2 id="lecturerheader">Hello, <%=lecturer.getStaffName()%>&nbsp;<i class="fa fa-smile-o"></i></h2>
	<div class="lecturercontainer">
		<h3>Edit Profile:</h3><br>
		<form onsubmit="return checkvalue()" action="UpdateLecturerInfoServlet" method="post">
			<input type="hidden" name="hiddenID" value="<%=lecturer.getId()%>">
			<p><b>Name:</b><input type="text" name="staffName" class="form-control" value="<%=lecturer.getStaffName()%>" required autofocus></p>
			<p><b>Staff Number:</b><input type="text" name="staffID" id="staffID" class="form-control" value="<%=lecturer.getStaffNumber()%>" required autofocus></p>
			<div style="color: #FF0000;">${errorMessage}</div>
			<p><b>Old Password:</b>&nbsp;<span class="glyphicon glyphicon-question-sign" aria-hidden="true" title="Enter your current password"></span><input type="password" name="oldpassword" id="oldpass" class="form-control" required autofocus></p>
			<p><b>New Password:</b>&nbsp;<span class="glyphicon glyphicon-question-sign" aria-hidden="true" title="Enter the same password if you do not want to change it"></span><input type="password" name="newpassword" id="newpass" class="form-control" required autofocus></p>
			<button class="btn btn-primary" id="updateprofile" type="submit">Done (login again)</button>
		</form>
	</div>
    <%
		}
	}
    %>
    
    <div id="space"></div>
    <footer class="footer">
	   <p id="copyright">&copy; 2017 Singapore Polytechnic (DISM/FT/3A/62)</p>
	</footer>
	
    <script type="text/javascript">
		function checkvalue() { 
			var staffID = document.getElementById('staffID').value; 
			var newpass = document.getElementById('newpass').value;
			var no = /^[0-9]+$/;
			var alp = /^[a-zA-Z]+$/;
			if (staffID.length != 8) {
				alert('Staff number must not be more than 8 characters long!');
				return false;
			}
			if (newpass.length < 8 || newpass.length > 16) {
			   	alert ('New password must be of length 8 to 16!');
		    	return false;
			}
			if (!no.test(newpass) && !alp.test(newpass)) {
			}
			else {
			   	alert ('New password must contain both alphabets and numbers!');
			   	return false;
			}
				    
			return true;
		}
	</script>
	    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="dist/js/bootstrap.min.js"></script>
</body>
</html>