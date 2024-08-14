<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Category List</title>
</head>
<body>
<h2>Category List</h2>
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
            <td>${category.status == 1 ? 'Active' : 'Inactive'}</td>
            <td>
                <a href="editCategory?id=${category.id}">Edit</a>
                <form action="changeStatus" method="post" style="display:inline;">
                    <input type="hidden" name="id" value="${category.id}">
                    <input type="hidden" name="status" value="${category.status == 1 ? 0 : 1}">
                    <input type="submit" value="${category.status == 1 ? 'Deactivate' : 'Activate'}">
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br>
<a href="addCategory.jsp">Add New Category</a>
</body>
</html>
