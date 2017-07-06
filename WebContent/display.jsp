<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,java.util.*,db.*,controller.*,model.*,java.util.Date,java.text.*,java.util.concurrent.TimeUnit"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
    
    <%
		}
	}
    %>
<%
ArrayList<AssessmentInfoDetails> retrieveAssessmentInfo = (ArrayList<AssessmentInfoDetails>)session.getAttribute("assessment");

if (retrieveAssessmentInfo != null) {
	for(AssessmentInfoDetails assessment:retrieveAssessmentInfo) { %>
		<h2><%=assessment.getModuleName()%></h2>
		<h2>Exam Code: <%=assessment.getExamCode()%></h2>
<%
	}
}

//Get Current time
DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
Date date = new Date();
Date currentTime = dateFormat.parse(dateFormat.format(date));

ArrayList<StudentInfoDetails> retrieveStudentInfo = (ArrayList<StudentInfoDetails>)session.getAttribute("student");

if (retrieveStudentInfo != null) {
	for(StudentInfoDetails student:retrieveStudentInfo) {
		Date timestamps = dateFormat.parse(student.getTimestamp()); //convert to Date
		long diff = currentTime.getTime()-timestamps.getTime(); //difference in time in milliseconds
		long diffsecs = TimeUnit.MILLISECONDS.toSeconds(diff); //convert to seconds
		out.print("Current time: " + dateFormat.format(date) + " | Timestamp: " + student.getTimestamp() + " | Time difference: " + diffsecs + " seconds");
		if (diffsecs <= 8) {
			out.println(" => Correct<br />");
		}
		else {
			out.println(" => Wrong<br />");
		}
	}	
}

%>

</body>
</html>