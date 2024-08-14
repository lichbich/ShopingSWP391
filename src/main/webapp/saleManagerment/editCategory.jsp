<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Category</title>
    <link rel="stylesheet" href="/static/css/style.css">
</head>
<body>
<h2>Edit Category</h2>
<form action="EditCategoryServlet" method="post">
    <input type="hidden" name="id" value="${category.id}">

    <label for="description">Description:</label>
    <input type="text" id="description" name="description" value="${category.description}" required><br><br>

    <label for="status">Status:</label>
    <select id="status" name="status" required>
        <option value="1" <%= category.status == 1 ? "selected" : "" %>>Active</option>
        <option value="0" <%= category.status == 0 ? "selected" : "" %>>Inactive</option>
    </select><br><br>

    <input type="submit" value="Update Category">
</form>
<a href="listCategory.jsp">Back to List</a>
</body>
</html>
