<%--
  Created by IntelliJ IDEA.
  User: locpx
  Date: 8/11/2024
  Time: 10:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>List All Categories</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/listCategories.css">
</head>
<body>
<div class="container">
  <header>
    <h1>Product Categories</h1>
    <div class="header-actions">
      <div class="filters">
        <div class="filter-group">
          <label for="search-bar">Search:</label>
          <input type="text" id="search-bar" placeholder="Search categories...">
        </div>
        <div class="filter-group">
          <label for="status-filter">Status:</label>
          <select id="status-filter">
            <option value="">All Status</option>
            <option value="active">Active</option>
            <option value="inactive">Inactive</option>
          </select>
        </div>
      </div>
      <button id="add-category-btn">Add Category</button>
    </div>
  </header>

  <!-- Category Table -->
  <table class="category-table">
    <thead>
    <tr>
      <th>Image</th>
      <th>Name</th>
      <th>Status</th>
      <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="category" items="${categories}">
      <tr>
        <td><img src="https://via.placeholder.com/100" alt="${category.name}"></td>
        <td>${category.name}</td>
        <td>
          <label class="status-switch">
            <input type="checkbox" class="status-checkbox" <c:if test="${category.status}">checked</c:if> >
            <span class="slider"></span>
            <span class="status-text">${category.status ? "Active" : "Inactive"}</span>
          </label>
        </td>
        <td><button class="edit-btn">Edit</button></td>
      </tr>
    </c:forEach>
    </tbody>
  </table>

  <!-- Pagination -->
  <div class="pagination">
    <a href="#" class="prev">« Prev</a>
    <a href="#" class="page-number">1</a>
    <a href="#" class="page-number">2</a>
    <a href="#" class="page-number">3</a>
    <a href="#" class="next">Next »</a>
  </div>
</div>
</body>
</html>
