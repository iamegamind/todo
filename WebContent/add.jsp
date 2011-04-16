<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add new todo</title>
</head>
<body>
<form action="check.jsp" method="post">
<p>Name: <input type="text" id="name" name="name"/></p>
<p>Date: <input type="text" id="date" name="date" value="dd/mm/yy" size="8" maxlength="8"></p>
<p>Description: <br/>
<textarea rows="5" name="description"></textarea></p>
<p>Priority: <br/>
<input type="radio" name="priority" value="high"/>High
<input type="radio" name="priority" value="normal"/>Normal
<input type="radio" name="priority" value="low"/>Low</p>
<input type="submit" value="Save">
</form>
</body>
</html>