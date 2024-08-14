<%@ page import="com.vn.fpt.g1.shop.dto.CategoryDto" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Category</title>
    <link rel="stylesheet" type="text/css" href="static/css/style.css">
</head>
<body>
<h1>Edit Category</h1>
<form action="editCategory" method="post">
    <input type="hidden" name="category_id" value="<%= request.getParameter("category_id") %>" />
    <label>Description:</label>
    <input type="text" name="description" value="<%= request.getAttribute("description") %>" required />
    <label>Status:</label>
    <select name="status" required>
        <option value="1" <%= (Integer.parseInt(request.getAttribute("status").toString()) == 1 ? "selected" : "") %>>Active</option>
        <option value="0" <%= (Integer.parseInt(request.getAttribute("status").toString()) == 0 ? "selected" : "") %>>Inactive</option>
    </select>
    <button type="submit">Update Category</button>
</form>
</body>
</html>
