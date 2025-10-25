<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
  String user = (String) session.getAttribute("user");
  if (user == null) {
    response.sendRedirect("login.jsp");
    return;
  }
%>
<!DOCTYPE html>
<html>
<head><title>Welcome</title></head>
<body>
  <h2>Welcome, <%= user %>!</h2>
  <a href="logout">Logout</a>
</body>
</html>
