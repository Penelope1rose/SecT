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
	            <li><a href="profile.jsp">Profile</a></li>
	            <li><a href="detailedhelp.jsp">Help</a></li>
	            <li><a href="LogoutServlet">Log out</a></li>
	          </ul>
	        </li>
          </ul>
        </div>
      </div>
    </nav>

    <div class="container-fluid">
      <div class="row">
      <h2 id="assessmentheader">Upcoming Assessments
	      <a title="List all assessments" href="RetrieveAllAssessmentInfoServlet?staffID=<%=lecturer.getStaffNumber()%>">
	      	<span class="glyphicon glyphicon-list-alt" id="listall" aria-hidden="true"></span>
	      </a>
      </h2>
      <form action="RetrieveSpecifiedModuleInfoServlet">
      <input type="hidden" name="staffID" value="<%=lecturer.getStaffNumber()%>">
      <button class="btn btn-default" id="add">
			<span class="glyphicon glyphicon-plus" id="addbox" aria-hidden="true"> Add Assessment</span>
	  </button>
	  </form>
          <%
		}
	}
    %>
          	<%
          	ArrayList<AssessmentInfoDetails> retrieveAssessmentInfo = (ArrayList<AssessmentInfoDetails>)session.getAttribute("assessment");

			if (retrieveAssessmentInfo != null) {
				for(AssessmentInfoDetails assessment:retrieveAssessmentInfo) {
					if (assessment.getStarted() == 0) {
					String datetime = assessment.getDatetime().replace(".0", "");
		%>
        <div class="main">
          <h3 class="page-header"><%=assessment.getAssessmentName()%>
			<form action="DeleteAssessmentInfoServlet" id="delete">
			<input type="hidden" name="staffID" value="<%=assessment.getLecturerID()%>">
			<input type="hidden" name="hiddenID" value="<%=assessment.getId()%>">
			<button class="btn btn-default" >
				<span class="glyphicon glyphicon-minus" id="deletebox" aria-hidden="true"> Delete</span>
			</button>
			</form>
			
			<form id="start" onClick="window.open('RetrieveStartAssessmentInfoServlet?hiddenID=<%=assessment.getId()%>');">
			<button class="btn btn-default" id="startbutton">
				<span class="glyphicon glyphicon-copy" id="startbox" aria-hidden="true"> Start</span>
			</button>
			</form>
			
			<form id="domains" action="RetrieveDomainInfoServlet">
			<input type="hidden" name="assessmentId" value="<%=assessment.getId()%>">
			<button class="btn btn-default" id="startbutton">
				<span class="glyphicon glyphicon-copy" id="domainbox" aria-hidden="true"> Domains</span>
			</button>
			</form>
			
		  </h3>
          <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>Assessment ID</th>
                  <th>Module Code</th>
                  <th>Module Name</th>
                  <th>Assessment Name</th>
                  <th>Time Limit (minutes)</th>
                  <th>Date and Time</th>
                  <th>Code</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td><%=assessment.getId()%></td>
                  <td><%=assessment.getModuleCode()%></td>
                  <td><%=assessment.getModuleName()%></td>
                  <td><%=assessment.getAssessmentName()%></td>
                  <td><%=assessment.getPeriod()%></td>
                  <%
                  	out.print("<td>" + datetime + "</td>");
                  %>
                  <td><%=assessment.getExamCode()%></td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
                <%
					}
				}
			}
            %>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="dist/js/bootstrap.min.js"></script>
</body>
</html>