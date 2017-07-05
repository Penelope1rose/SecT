<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,java.util.*,db.*,controller.*,model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

    <title>Secured-T</title>

    <!-- Bootstrap core CSS -->
    <link href="dist/css/bootstrap.min.css" rel="stylesheet">

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
          <a class="navbar-brand" id="homenav" href="home.jsp"><img src="images/logo.png" alt="Secured-T logo" id="logo">Secured-T</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li class="dropdown">
	          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><span class="glyphicon glyphicon-user" aria-hidden="true"></span>&nbsp;<%=lecturer.getStaffName()%>&nbsp;<span class="caret"></span></a>
	          <ul class="dropdown-menu">
	            <li><a href="#">Settings</a></li>
	            <li><a href="#">Profile</a></li>
	            <li><a href="#">Help</a></li>
	          </ul>
	        </li>
          </ul>
        </div>
      </div>
    </nav>
    <div class="addcontainer">
    <h2 id="addassessmentheader">Add Assessment</h2>
    	<form onsubmit="return checkvalue()" action="InsertLecturerInfoServlet" method="post" class="form-signin">
	        Admission number: <input type="text" name="staffID" id="staffID" class="form-control" placeholder="E.g. S1234567" required autofocus><br>
	        Name: <input type="text" name="staffName" class="form-control" required autofocus><br>
	        Password: <input type="password" name="password" id="password" class="form-control" required autofocus><br>
	        Confirm Password: <input type="password" id="password2" class="form-control" required autofocus><br>
	        <button class="btn btn-primary" id="signupnext" type="submit">Next</button>
		</form>
	</div>
    <%
		}
	}
    %>

</body>
</html>