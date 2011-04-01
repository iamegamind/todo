<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.ArrayList, todolist.ToDo"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ToDo</title>
</head>
<body>
<jsp:useBean id="MainJSPBean" class="todolist.MainJSPBean" scope="session"/>
Hello,  <%=MainJSPBean.getCurrentUser().getName()%>!<br>
	<%ArrayList<ToDo> list = MainJSPBean.getToDos();
	for (ToDo t: list) { %>
		<%=t.getName() %><br>
		<%=t.getDescription() %><br>
		<%=t.getDate() %><hr>
		<%} %>
</body>
</html>