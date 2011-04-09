<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1", import="todolist.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
	<%Controller c = (Controller) session.getAttribute("Controller");
	String name = (String)request.getAttribute("name"); 
	String description = (String)request.getAttribute("description");
	String date = (String)request.getAttribute("date");
	String priority = (String)request.getAttribute("priority");
	ToDo todo = new ToDo(c.getCurrentUser().getLogin(),date,name,priority,description, false);
	ToDo t = c.addToDo(todo);
	if (t==null) {
		session.setAttribute("errorMsg", "You have todo with this name.");
%> <jsp:forward page="add.jsp">
<%}
	session.setAttribute("info", "ToDo added");
	session.setAttribute("errorMsg", "");%>
	<jsp:forward page="main.jsp">
</body>
</html>