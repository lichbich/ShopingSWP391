<%@ page import="java.util.List" %>
<%@ page import="com.vn.fpt.g1.shop.dto.CategoryDto" %>
<!DOCTYPE html>
<html>
<head>
    <title>Category List</title>
    <link rel="stylesheet" type="text/css" href="static/css/style.css">
</head>
<body>
<h1>Category List</h1>
<a href="WEB-INF/saleManagerment/addCategory.jsp">Add New Category</a>
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
    <%
        List<CategoryDto> categories = (List<CategoryDto>) request.getAttribute("categories");
        for (CategoryDto category : categories) {
    %>
    <tr>
        <td><%= category.getId() %></td>
        <td><%= category.getDescription() %></td>
        <td><%= category.getStatus() %></td>
        <td>
            <a href="WEB-INF/saleManagerment/editCategory.jsp?category_id=<%= category.getId() %>">Edit</a>
            <a href="sWEB-INF/saleManagerment/changeStatus?category_id=<%= category.getId() %>&status=<%= category.getStatus() == 1 ? 0 : 1 %>">
                <%= category.getStatus() == 1 ? "Deactivate" : "Activate" %>
            </a>
        </td>
    </tr>
    <% } %>
    </tbody>
</table>
</body>
</html>
