<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List, todolist.*, todolist.model.ToDo"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ToDo</title>
</head>
<body>
<%Controller c = (Controller)session.getAttribute("Controller"); %>
Hello,  <%=c.getCurrentUser().getName()%>! <br />
<%=(String)session.getAttribute("info") %>
<%session.setAttribute("info", ""); %>
<input type="button" value="Add new todo" onclick="self.location.href='add.jsp'"/>
<input type="button" value="Change password" id="change" /><hr/>
	<%List<ToDo> list = c.getToDos();
	System.out.println(list==null);
	for (ToDo t: list) { %><form method="post" action="change.jsp">
		<%=t.getName() %><br />
		<%=t.getDescription() %><br />
		<%=t.getDate() %><br />
		<input type="hidden" value="<%=t.getName() %>" id="name" name="name" />
		<input type="submit" value="Change this ToDo" /><hr />
		</form>
		<%} %>
</body>
</html>