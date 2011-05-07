<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List, todolist.model.ToDo, todolist.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change todo</title>
</head>
<body>
<%String name = request.getParameter("name");
Controller c = (Controller)session.getAttribute("Controller");
ToDo todo = null;
List<ToDo> list = c.getToDos();
	for (ToDo t: list) { 
		if (t.getName().equals(name)) {
			todo = t;
			break;
		}
	}
%>
<form method="post" action="check.jsp">
<p>Name: <%=name %></p>
<input type="hidden" value="<%=name %>" name="name"/>
<p>Date:<input type="text" name="date" value="<%=todo.getDate() %>" /></p>
<p>Description:<br> 
<textarea rows="5" name="description" ><%=todo.getDescription() %></textarea></p>
<p>Priority: <br/>
<input type="radio" name="priority" value="high"/>High
<input type="radio" name="priority" value="normal"/>Normal
<input type="radio" name="priority" value="low"/>Low</p>
<p>
<input type="hidden" value="true" name="update"/>
<input type="submit" value="change"/>
</p>
</form>
</body>
</html>