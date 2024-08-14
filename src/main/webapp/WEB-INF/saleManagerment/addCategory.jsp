<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Add New Category</title>
</head>
<body>
<h2>Add New Category</h2>
<form action="addCategory" method="post">
  <label for="description">Description:</label>
  <input type="text" id="description" name="description" required>
  <br>
  <label for="status">Status:</label>
  <select id="status" name="status" required>
    <option value="1">Active</option>
    <option value="0">Inactive</option>
  </select>
  <br>
  <input type="submit" value="Add Category">
</form>
<br>
<a href="listCategory.jsp">Back to List</a>
</body>
</html>
