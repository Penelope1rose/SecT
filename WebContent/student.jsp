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
	<%
          	ArrayList<AssessmentInfoDetails> retrieveAllAssessmentInfo = (ArrayList<AssessmentInfoDetails>)session.getAttribute("assessment");

			if (retrieveAllAssessmentInfo != null) {
				for(AssessmentInfoDetails assessment:retrieveAllAssessmentInfo) {
		%>
      	<h2 id="studentsheader"><%=assessment.getAssessmentName()%></h2>
            <%
				}
			}
            %>            
       <div class="main">
          <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>Admission Number</th>
                  <th>IP Address</th>
                  <th>Port Number</th>
                  <th>Last Updated Time</th>
                  <th>File Name</th>
                  <th>Version</th>
                </tr>
              </thead>
         <%
          	ArrayList<StudentInfoDetails> retrieveStudentInfo = (ArrayList<StudentInfoDetails>)session.getAttribute("student");

			if (retrieveStudentInfo != null) {
				for(StudentInfoDetails student:retrieveStudentInfo) {
		%>
              <tbody>
                <tr>
                  <td><%=student.getAdminNo()%></td>
                  <td><%=student.getIpAddr()%></td>
                  <td><%=student.getPortNo()%></td>
                  <td><%=student.getTimestamp()%></td>
                  <td><%=student.getFileName()%></td>
                  <td><%=student.getVersion()%></td>
                </tr>
              </tbody>

        <%
			   	}
			}
        %>
        		</table>
         	</div>
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