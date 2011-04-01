<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="todolist.*"%>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<title>ToDo</title>
</head>
<body>
	<jsp:useBean id="loginJSPBean" class="todolist.LoginJSPBean" scope="session"/> 
	<font color="red">
	<jsp:getProperty name="loginJSPBean" property="errorMsg"/> </font>
	<form id="thisForm" method="post" action="login.jsp" >
		<p>Login: <input id="login" type="text" name="login" /></p>
		<p>Password: <input id="password" type="password" name="password" /></p>
		<input id="action" type="hidden" value="login"/>
		<input type="submit" value="login" />
		<input type="button" value="register" onclick="thisForm.action.value='register'; thisForm.submit(); return false;"/>
		<input type="button" value="show action" onclick="alert(thisForm.action.value); return false;"/>
	</form>

</body>
</html>