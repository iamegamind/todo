<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="todolist.model.User, todolist.Controller"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<%Controller c = (Controller)session.getAttribute("Controller");
	if (c == null) c = new Controller();
	String register = request.getParameter("register");
	if (register!=null) {
		String name = request.getParameter("name");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		User user = new User(name, login, password);
		user = c.register(user);
		if (user==null) {
			session.setAttribute("errorMsg","This login is taken.");%>
			<jsp:forward page="register.jsp"/>
	<%	}
		session.setAttribute("errorMsg","");
		session.setAttribute("info","You have registrated");
		session.setAttribute("Controller", c);
	%>
	<jsp:forward page="main.jsp"/>
	<%} %>
	
	
	<% 
	
	User user = c.login(request.getParameter("login"), request.getParameter("password"));
	System.out.println("user="+user);
	if (user==null) {
		session.setAttribute("errorMsg","Invalid login/password.");%>
		<jsp:forward page="index.jsp"/>
	<%} 
	session.setAttribute("errorMsg","");
	session.setAttribute("info","");
	session.setAttribute("Controller", c);%>
	<jsp:forward page="main.jsp"/>
</body>
</html>