<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,java.util.*,db.*,controller.*,model.*,java.util.Date,java.text.*"%>
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
			//When lecturer click the refresh button in browser, it goes through the servlet
			if(session.getAttribute("REFRESH")!= null){ %>
				<script type="text/javascript">
	            	window.location.href = "RetrieveAllAnnouncementInfoServlet?staffID=<%=lecturer.getStaffNumber()%>"
	        	</script>
	        <%
			}
			else{    
				session.setAttribute("REFRESH","TRUE");
			}
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
    
    <%
		}
	}
    %>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
          	<li id="moduleheader"><a href="secondmoduleadd.jsp">Modules&nbsp;<span class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span></a></li>
          	<%
          	ArrayList<ModuleInfoDetails> retrieveModuleInfo = (ArrayList<ModuleInfoDetails>)session.getAttribute("module");

			if (retrieveModuleInfo != null) {
				for(ModuleInfoDetails module:retrieveModuleInfo) {
		%>
			<hr id="separator">
            <li id="modules"><%=module.getModName()%> (<%=module.getModCode()%>)</li>
            
            <%
				}
			}
            %>
          </ul>
          <ul class="nav nav-sidebar">
            <li id="assheader"><a href="assessmentinfo.jsp">Upcoming Assessments&nbsp;<span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span></a></li>
            <%
          	ArrayList<AssessmentInfoDetails> retrieveAssessmentInfo = (ArrayList<AssessmentInfoDetails>)session.getAttribute("assessment");

			if (retrieveAssessmentInfo != null) {
				for(AssessmentInfoDetails assessment:retrieveAssessmentInfo) {
		%>
            <hr id="separator">
            <li id="assessments"><%=assessment.getAssessmentName()%></li>
            <%
				}
			}
            %>
          </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
        	<div class="announcement">
          		<h2 id="announcement_title">Announcements</h2>
          		     <form action="RetrieveAnnouncementInfoServlet" class="navbar-form navbar-right" id="searchbar">
				        <div class="form-group">
				        <%
          	retrieveAssessmentInfo = (ArrayList<AssessmentInfoDetails>)session.getAttribute("assessment");

			if (retrieveAssessmentInfo != null) {
				for(AssessmentInfoDetails assessment:retrieveAssessmentInfo) {
		%>
				          <input type="hidden" name="staffID" value="<%=assessment.getLecturerID()%>">
				          <%
				}
			}
				          %>
				          <input type="text" name="modCode" class="form-control" placeholder="Search by module code">
				        </div>
				        <button type="submit" class="btn btn-default">Enter</button>
				      </form>
          <%
			  		ArrayList<AnnouncementInfoDetails> retrieveAnnouncement = (ArrayList<AnnouncementInfoDetails>)session.getAttribute("announcement");
			  		for(AnnouncementInfoDetails announcement:retrieveAnnouncement) {
						SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
			  		%>
					<p id="individual_announcement">
						<h3>Module Code: <%=announcement.getModuleCode()%></h3>
						(<%=dateFormat.format(announcement.getTimestamp())%>)
					</p>
					<p>
						<%=announcement.getAnnouncement()%>
					</p>

			<%
			  		}
			%>

	        </div>
	      </div>
	    </div>
    </div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="dist/js/bootstrap.min.js"></script>
</body>
</html>