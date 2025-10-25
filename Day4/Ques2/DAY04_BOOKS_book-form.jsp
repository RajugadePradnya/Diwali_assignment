<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.Book" %>
<jsp:useBean id="book" scope="request" class="Book" />
<html><head><title>Book Form</title></head><body>
  <h2>Book</h2>
  <form action="books" method="post">
    <input type="hidden" name="action" value="${param.action != null ? param.action : (book.id == 0 ? 'insert' : 'update') }" />
    <input type="hidden" name="id" value="${book.id}" />
    <label>Title: <input type="text" name="title" value="${book.title}" required></label><br/>
    <label>Author: <input type="text" name="author" value="${book.author}" required></label><br/>
    <label>Price: <input type="number" step="0.01" name="price" value="${book.price}" required></label><br/>
    <button type="submit">${book.id == 0 ? 'Insert' : 'Update'}</button>
  </form>
  <a href="books">Back</a>
</body></html>
