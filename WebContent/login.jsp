<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="todolist.User, todolist.Controller"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<% Controller c = (Controller)session.getAttribute("Controller");
	if (c == null) c = new Controller();
	User user = c.login(request.getParameter("login"), request.getParameter("password")); %>
	<% if (user==null) {
		session.setAttribute("errorMsg","Invalid login/password.");%>
		<jsp:forward page="index.jsp"/>
	<%} 
	session.setAttribute("errorMsg","");
	session.setAttribute("info","");
	session.setAttribute("Controller", c);%>
	<jsp:forward page="main.jsp"/>
</body>
</html>