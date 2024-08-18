<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <title>Edit Product</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/admin.css">
</head>
<body>
<h1>Edit Product</h1>
<form action="${pageContext.request.contextPath}/editProduct" method="post">
  <input type="hidden" name="productId" value="${product.productId}">
  <label for="name">Name:</label>
  <input type="text" id="name" name="name" value="${product.name}" required>
  <label for="description">Description:</label>
  <textarea id="description" name="description" required>${product.description}</textarea>
  <label for="price">Price:</label>
  <input type="number" id="price" name="price" step="0.01" value="${product.price}" required>
  <label for="categoryId">Category:</label>
  <select id="categoryId" name="categoryId" required>
    <!-- Populate with categories -->
  </select>
  <label for="status">Status:</label>
  <select id="status" name="status" required>
    <option value="1" ${product.status == 1 ? 'selected' : ''}>Active</option>
    <option value="0" ${product.status == 0 ? 'selected' : ''}>Inactive</option>
  </select>
  <button type="submit">Update Product</button>
</form>
<a href="${pageContext.request.contextPath}/productManagement/listProduct.jsp">Back to List</a>
</body>
</html>
