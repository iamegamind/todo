<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="todolist.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<jsp:useBean id="loginJSPBean" class="todolist.LoginJSPBean" scope="session"/> 
	<jsp:useBean id="MainJSPBean" class="todolist.MainJSPBean" scope="session"/>
	<jsp:setProperty name="loginJSPBean" property="*"/>
	<% User user = loginJSPBean.validate(); %>
	<% if (user==null) {%>
		<jsp:setProperty name="loginJSPBean" property="errorMsg" value="Invalid login/password. Try again"/>
		<jsp:forward page="index.jsp"/>
	<%} %>
	<jsp:setProperty name="loginJSPBean" property="errorMsg" value=""/>
	<%MainJSPBean.setCurrentUser(user);
	MainJSPBean.setController(loginJSPBean.getController());%>
	<jsp:forward page="main.jsp"/>
</body>
</html>