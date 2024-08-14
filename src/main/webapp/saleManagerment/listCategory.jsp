<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Category List</title>
    <link rel="stylesheet" href="/static/css/style.css">
</head>
<body>
<h2>Category List</h2>
<a href="addCategory.jsp">Add New Category</a>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Description</th>
        <th>Status</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="category" items="${categories}">
        <tr>
            <td>${category.id}</td>
            <td>${category.description}</td>
            <td>
                <form action="ChangeStatusServlet" method="post" style="display:inline;">
                    <input type="hidden" name="id" value="${category.id}">
                    <input type="hidden" name="status" value="${category.status == 1 ? 0 : 1}">
                    <button type="submit">${category.status == 1 ? "Deactivate" : "Activate"}</button>
                </form>
            </td>
            <td>
                <a href="EditCategoryServlet?id=${category.id}">Edit</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
