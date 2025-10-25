<%@ page import="java.util.*,javax.servlet.*,javax.servlet.http.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html><head><title>Books</title></head><body>
  <h2>Book List</h2>
  <a href="books?action=new">Add New Book</a>
  <table border="1" cellpadding="6" cellspacing="0">
    <tr><th>ID</th><th>Title</th><th>Author</th><th>Price</th><th>Actions</th></tr>
    <c:forEach var="b" items="${list}">
      <tr>
        <td>${b.id}</td>
        <td>${b.title}</td>
        <td>${b.author}</td>
        <td>${b.price}</td>
        <td>
          <a href="books?action=edit&id=${b.id}">Edit</a> |
          <a href="books?action=delete&id=${b.id}" onclick="return confirm('Delete?')">Delete</a>
        </td>
      </tr>
    </c:forEach>
  </table>
</body></html>
