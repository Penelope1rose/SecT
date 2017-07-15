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
    <link rel="stylesheet" href="dist/css/bootstrap-datetimepicker.min.css" />
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
    <div class="addcontainer">
    <h2 id="addassessmentheader">Add Assessment</h2>
    	<form action="InsertAssessmentInfoServlet">
	    	<input type="hidden" name="modCode" id="modCode">
	    	<input type="hidden" name="modName" id="modName">
	    	<input type="hidden" name="staffID" value="<%=lecturer.getStaffNumber()%>">
	        <div class="form-group">
			  <label for="modCode">Module:&nbsp;<span class="glyphicon glyphicon-question-sign" aria-hidden="true" title="Module must be added before you can add assessments"></span></label>
			  <select class="form-control" id="moddropdown" required>
			  	<option></option>
		<%
    	ArrayList<ModuleInfoDetails> retrieveModuleInfo = (ArrayList<ModuleInfoDetails>)session.getAttribute("module");

    	if (retrieveModuleInfo != null) {
    		for(ModuleInfoDetails module:retrieveModuleInfo) { 
    	%>
			    <option><%=module.getModName()%> (<%=module.getModCode()%>)</option>
		<%
    		}
    	}
		%>
		<script type="text/javascript">
			$('#moddropdown').change(function () {
			    var selectedText = $(this).find("option:selected").text();
			    var modCode = selectedText.match(/\((.*)\)/);
			    $("#modCode").val(modCode[1]);
			    var modName = selectedText.substr(0, selectedText.indexOf(' (')); 
			    $("#modName").val(modName);
			});
			
			$('form').submit( function () {
			    $('#datetime').each( function() {
			        $(this).val(moment(new Date($(this).val())).format("YYYY-MM-DD HH:mm:ss"))
			    });
			})
		</script>
			  </select>
			</div>
	        Assessment Name: <input type="text" name="assessmentName" class="form-control" required autofocus><br>
	        Time Limit (minutes): <input type="number" name="period" min="1" class="form-control" required autofocus><br>
	        Date and Time:
			<div class='input-group date' id='datetimepicker1'>
                    <input type='text' class="form-control" name="datetime" id="datetime"/>
                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span>
            </div><br>
            Exam Code: <span class="glyphicon glyphicon-question-sign" aria-hidden="true" title="The code for students to access the assessment"></span>
            <input type="text" name="examCode" class="form-control" required autofocus><br>
	        <button class="btn btn-primary" id="addass" type="submit">Next</button>
		</form>
   
	</div>

    <%
		}
	}
    %>
    <script type="text/javascript">
            $(function () {
                $('#datetimepicker1').datetimepicker();
            });
    </script>
    
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script type="text/javascript" src="dist/js/moment.min.js"></script>
	<script type="text/javascript" src="dist/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="dist/js/bootstrap-datetimepicker.min.js"></script>
	<script type="text/javascript" src="dist/js/bootstrap-tagsinput.js"></script>
	<script type="text/javascript" src="dist/js/bootstrap-tagsinput-angular.js"></script>
</body>
</html>