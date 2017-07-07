<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,java.util.*,db.*,controller.*,model.*,java.util.Date,java.text.*,java.util.concurrent.TimeUnit"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Secured-T</title>

    <!-- JS -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    
    <!-- Bootstrap core CSS -->
    <link href="dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/display.css" rel="stylesheet">
    
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
//Get Current time
DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
Date date = new Date();
Date currentTime = dateFormat.parse(dateFormat.format(date));

ArrayList<AssessmentInfoDetails> retrieveAssessmentInfo = (ArrayList<AssessmentInfoDetails>)session.getAttribute("assessment");

if (retrieveAssessmentInfo != null) {
	for(AssessmentInfoDetails assessment:retrieveAssessmentInfo) { 
	//When student click the refresh button in browser, it goes through the servlet
	if(session.getAttribute("REFRESH")!= null){ %>
		<script type="text/javascript">
	    	window.location.href = "RetrieveStartAssessmentInfoServlet?examCode=<%=assessment.getExamCode()%>"
		</script>
	<%
	}
	else{    
		session.setAttribute("REFRESH","TRUE");
	}
	%>
	<div id="startexamheader">
		<h2><%=assessment.getModuleName()%>
		<p id="systemtime">System Time: <%=dateFormat.format(date)%></p>
		</h2>
		<h2>Exam Code: <%=assessment.getExamCode()%></h2>
	</div>
	
	<script type="text/javascript">
	setTimeout(function(){
		   window.location="RetrieveStudentInfoServlet?examCode=<%=assessment.getExamCode()%>";
		}, 10000);
	</script>
<div id="allcomp">
	<ul class="list-inline" id="allcompimg">
<%
	}
}

ArrayList<StudentInfoDetails> retrieveStudentInfo = (ArrayList<StudentInfoDetails>)session.getAttribute("student");
boolean showAlert = true;
if (retrieveStudentInfo != null) {
	for(StudentInfoDetails student:retrieveStudentInfo) {
		Date timestamps = dateFormat.parse(student.getTimestamp()); //convert to Date
		long diff = currentTime.getTime()-timestamps.getTime(); //difference in time in milliseconds
		long diffsecs = TimeUnit.MILLISECONDS.toSeconds(diff); //convert to seconds
		if (diffsecs <= 8) { %>
			<li id="compimg"><img src="images/L3.png" id="connected" alt="Connected" data-toggle="tooltip" data-placement="top" data-html="true" title="Admission Number: <%=student.getAdminNo()%><br>IP address: <%=student.getIpAddr()%><br>Port Number: <%=student.getPortNo()%><br>Timestamp: <%=student.getTimestamp()%>"></li>
		<%
		}
		else { %>
			<li id="compimg"><img src="images/L2.png" id="disconnected" alt="Disconnected" data-toggle="tooltip" data-placement="top" data-html="true" title="Admission Number: <%=student.getAdminNo()%><br>IP address: <%=student.getIpAddr()%><br>Port Number: <%=student.getPortNo()%><br>Timestamp: <%=student.getTimestamp()%>"></li>
		<%
			if (showAlert == true) { %>
			<script type="text/javascript">
				alert ("1 or more student(s) has/have disconnected!");
			</script>
			<%
				showAlert = false;
			}
		}
	}	
}

%>
	</ul>
</div>

<script type="text/javascript">
$(document).ready(function(){
    $('[data-toggle="tooltip"]').tooltip();   
});
</script>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="dist/js/bootstrap.min.js"></script>
</body>
</html>