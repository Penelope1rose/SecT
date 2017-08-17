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
    <%
		}
	}
    %>

	<h2 id="instructionheader">Guide</h2>
	<div class="instructioncontainer">
	<h3>Step by step guide:</h3>
		<p>
			1) Before doing anything, add the modules that you are in charge of.<br>
			2) After that, you can proceed to add assessments for the different modules.<br>
			3) Then, for each assessment, you can add domains that the student is allowed access during the assessment.<br>
			4) You can then add announcements to the different assessments.<br><br>
			These announcements will be shown on the students' website for the assessment they are taking.<br><br>
			5) When you want to start an assessment, click the start button next to that particular assessment.<br><br>
			A new window will open and from there, you can monitor the students' status and view details of students.<br><br>
			<div id="green">
				<img src="images/L3.png" alt="Connected" data-toggle="tooltip" data-placement="top" data-html="true">
				<p id="greentext">A green laptop means that the student is connected and nothing is wrong. From here, you can start and stop screen capture and keylogging.</p>
			</div>
			<div id="blue">
				<img src="images/L2.png" alt="Connected" data-toggle="tooltip" data-placement="top" data-html="true">
				<p id="bluetext">A red laptop means that the student is connected but <b>CHEATING</b>.</p>
			</div>
			<div id="red">
				<img src="images/L1.png" alt="Connected" data-toggle="tooltip" data-placement="top" data-html="true">
				<p id="redtext">A grey laptop means that the student is <b>DISCONNECTED</b>. From here, you can remove the laptop if it is not needed anymore.</p>
			</div>
			<p id="imptmessage">**Important**<br>
				After the assessment has ended, end the assessment properly by clicking the 'End Assessment' button.
				If you press the (x) button to close the window, the assessment will not be considered finished.
			</p>
			6) After the end of an assessment, it will be removed from upcoming assessments.<br><br>
			7) To see student details or clear database information related to an assessment, proceed to list all assessments.<br><br>
			<p id="imptmessage">**Important**<br>
				Make sure you do not need the information related to the assessment anymore before you clear the database related to it.
			</p>
		</p>
    </div>
    
    <div id="space"></div>
    <footer class="footer">
	   <p id="copyright">&copy; 2017 Singapore Polytechnic (DISM/FT/3A/62)</p>
	</footer>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="dist/js/bootstrap.min.js"></script>
</body>
</html>