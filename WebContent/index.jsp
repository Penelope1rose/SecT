<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://fonts.googleapis.com/css?family=Revalia" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/index.css" rel="stylesheet">
    
    <!-- Favicon -->
	<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
	<link rel="icon" href="images/favicon.ico" type="image/x-icon">
		
<title>Secured-T Login</title>
</head>
<body>
<div class="login-page">
     <h1>Secured-T</h1>
  <div class="form">
    <form class="login-form" method="post" action="RetrieveLecturerInfoServlet">
      <div style="color: #FF0000;">${errorMessage}</div>
      <input type="text" name="staffID" placeholder="staff ID" required auto-focus>
      <input type="password" name="password" placeholder="password" required auto-focus>
      <input type="submit" id="loginbutton" value="login">
      <p class="message">Not registered? <a href="signup.jsp">Create an account</a></p>
    </form>
  </div>
</div>

</body>
</html>