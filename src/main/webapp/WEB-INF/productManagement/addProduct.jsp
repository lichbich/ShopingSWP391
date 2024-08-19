<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Add Product</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/admin.css">
</head>
<body>
<h1>Add New Product</h1>
<form action="addProduct" method="post">
  <label for="name">Name:</label>
  <input type="text" id="name" name="name" required><br>
  <label for="description">Description:</label>
  <textarea id="description" name="description" required></textarea><br>
  <label for="price">Price:</label>
  <input type="number" id="price" name="price" step="0.01" required><br>
  <label for="categoryId">Category ID:</label>
  <input type="number" id="categoryId" name="categoryId" required><br>
  <label for="status">Status:</label>
  <select id="status" name="status">
    <option value="1">Active</option>
    <option value="0">Inactive</option>
  </select><br>
  <input type="submit" value="Add Product">
</form>
</body>
</html>
