<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<body>
<%String error = (String)session.getAttribute("errorMsg");
	if (error == null) error="";%>
<font color="red">
<%=error %></font>
<%session.setAttribute("errorMsg", ""); %><br/>
<form action="login.jsp" method="post">
<p>Name:<input type="text" name="name" /></p>
<p>Login:<input type="text" name="login" /></p>
<p>Password:<input type="password" name="password" /></p>
<p><input type="submit" value="register" /></p>
<input type="hidden" name="register" value="true">
</form>
</body>
</html>