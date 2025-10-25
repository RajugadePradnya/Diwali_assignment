<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><title>Login</title></head>
<body>
  <h2>Login</h2>
  <form action="login" method="post">
    <label>Login ID: <input type="text" name="loginid" required></label><br/><br/>
    <label>Password: <input type="password" name="password" required></label><br/><br/>
    <button type="submit">Login</button>
  </form>
  <p style="color:red">${error}</p>
</body>
</html>
