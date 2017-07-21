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
    <link rel="stylesheet" href="dist/css/bootstrap-tagsinput.css" />

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
          	<%
          	ArrayList<AssessmentInfoDetails> retrieveAssessmentInfo = (ArrayList<AssessmentInfoDetails>)session.getAttribute("dassessment");

			if (retrieveAssessmentInfo != null) {
				for(AssessmentInfoDetails assessment:retrieveAssessmentInfo) {
		%>
		<h2 id="domainheader">White-listed Domains for<br><%=assessment.getAssessmentName()%></h2>
        <div class="domaincontainer">

            <ol>
        <%
          	ArrayList<DomainInfoDetails> retrieveDomainInfo = (ArrayList<DomainInfoDetails>)session.getAttribute("domain");

			if (retrieveDomainInfo != null) {
				for(DomainInfoDetails domain:retrieveDomainInfo) {
		%>
			      <p id="dbdomain<%=domain.getId()%>" class="dbdomain"><%=domain.getDomainName()%></p>
			      
                  	<h3><li id="assdomain<%=domain.getId()%>" class="assdomain">&nbsp;<a href="DeleteDomainInfoServlet?hiddenID=<%=domain.getId()%>&assessmentId=<%=domain.getAssessmentId()%>" id="deletedomain"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a></li></h3>
                  
                  <script type="text/javascript">
                  	var dbdomain = $("#dbdomain<%=domain.getId()%>").html();
          			domain = dbdomain.replace(/\\/g, '');
          			$("#assdomain<%=domain.getId()%>").prepend(domain);
                  </script>
        <%
					}
				}
    	%>
    	</ol>
    	<form onsubmit="return checkvalue()" action="InsertDomainInfoServlet" id="domainform">
    	<input type="hidden" name="staffID" value="<%=lecturer.getStaffNumber()%>">
    	<input type="hidden" name="assessmentId" value="<%=assessment.getId()%>">
	        Add Domains: <span class="glyphicon glyphicon-question-sign" aria-hidden="true" title="Domains that students are allowed to access (must start with www.)"></span>
            <input type="text" id="domain" name="domain" data-role="tagsinput" placeholder="Enter to confirm the domain " required autofocus><br><br>
	        <button class="btn btn-primary" id="adddomain" type="submit">Done</button>
		</form>
          </div>
        </div>
      </div>
                  <%
					}
				}
		}
	}
    %>
    
    <div id="space"></div>
    <footer class="footer">
	   <p id="copyright">&copy; 2017 Singapore Polytechnic (DISM/FT/3A/62)</p>
	</footer>

	<script type="text/javascript">
    $(document).ready(function() {
        $("form").bind("keypress", function(e) {
           if (e.keyCode == 13) {
              return false;
           }
        });
     });
    
    function checkvalue() { 
		var domain = document.getElementById('domain').value;
		var start = /^www./;

		if (!start.test(domain)) {
			alert ('The domain must start with www.');
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
   	<script type="text/javascript" src="dist/js/bootstrap-tagsinput.js"></script>
	<script type="text/javascript" src="dist/js/bootstrap-tagsinput-angular.js"></script>
</body>
</html>