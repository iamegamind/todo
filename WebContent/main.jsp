<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.ArrayList, todolist.*"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ToDo</title>
</head>
<body>
<jsp:useBean id="MainJSPBean" class="todolist.MainJSPBean" scope="session"/>
<%Controller c = (Controller)session.getAttribute("Controller"); %>
Hello,  <%=c.getCurrentUser().getName()%>! <br />
<%=(String)session.getAttribute("info") %>
<input type="button" value="Add new todo" onclick="self.location.href='add.jsp'"/>
<input type="button" value="Change password" id="change" /><hr/>
	<%ArrayList<ToDo> list = c.getToDos();
	for (ToDo t: list) { %>
		<%=t.getName() %><br />
		<%=t.getDescription() %><br />
		<%=t.getDate() %><br />
		<input type="button" value="Change this ToDo"/><hr />
		<%} %>
</body>
</html>