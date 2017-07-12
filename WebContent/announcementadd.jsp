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
          <a class="navbar-brand" id="homenav" href="home.jsp"><img src="images/logo.png" alt="Secured-T logo" id="logo">Secured-T</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li class="dropdown">
	          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><span class="glyphicon glyphicon-user" aria-hidden="true"></span>&nbsp;<%=lecturer.getStaffName()%>&nbsp;<span class="caret"></span></a>
	          <ul class="dropdown-menu">
	            <li><a href="#">Profile</a></li>
	            <li><a href="#">Help</a></li>
	            <li><a href="#">Log out</a></li>
	          </ul>
	        </li>
          </ul>
        </div>
      </div>
    </nav>
    
    <div class="addcontainer">
    <h2 id="addannouncementheader">Add Announcement</h2>
    	<form action="InsertAnnouncementInfoServlet">
    		<input type="hidden" name="modCode" id="modCode">
    		<input type="hidden" name="staffID" value="<%=lecturer.getStaffNumber()%>">
    		<input type="hidden" name="staffName" value="<%=lecturer.getStaffName()%>">
    		<%
		}
	}
    		%>
	        <div class="form-group">
			  <label for="modCode">Assessment:&nbsp;<span class="glyphicon glyphicon-question-sign" aria-hidden="true" title="An assessment must be created for a particular module before you can add announcements"></span></label>
			  <select class="form-control" id="assdropdown" required>
			  	<option></option>
		<%
    	ArrayList<AssessmentInfoDetails> retrieveAssessmentInfo = (ArrayList<AssessmentInfoDetails>)session.getAttribute("assessment");

    	if (retrieveAssessmentInfo != null) {
    		for(AssessmentInfoDetails assessment:retrieveAssessmentInfo) { 
    	%>
			    <option><%=assessment.getAssessmentName()%> (<%=assessment.getModuleCode()%>)</option>
		<%
    		}
    	}
		%>
		<script type="text/javascript">
			$('#assdropdown').change(function () {
			    var selectedText = $(this).find("option:selected").text();
			    var modCode = selectedText.match(/\((.*)\)/);
			    $("#modCode").val(modCode[1]);
			});
		</script>
			  </select>
			</div><br>
			<div class="form-group">
			  <label for="announcement">Announcement:</label>
			  <textarea class="form-control" rows="5" name="announcement" required autofocus></textarea>
			</div>

	        <button class="btn btn-primary" id="addann" type="submit">Add</button>
		</form>
	</div>
	<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="dist/js/bootstrap.min.js"></script>
</body>
</html>