<%@ page import="com.vn.fpt.g1.shop.dto.ProductDto" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product List</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/admin.css">
</head>
<body>
<h1>Product List</h1>
<a href="addProduct.jsp">Add New Product</a>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Description</th>
        <th>Price</th>
        <th>Category ID</th>
        <th>Status</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="product" items="${productList}">
        <tr>
            <td><c:out value="${product.productId}"/></td>
            <td><c:out value="${product.name}"/></td>
            <td><c:out value="${product.description}"/></td>
            <td><c:out value="${product.price}"/></td>
            <td><c:out value="${product.categoryId}"/></td>
            <td>
                <c:choose>
                    <c:when test="${product.status == 1}">Active</c:when>
                    <c:otherwise>Inactive</c:otherwise>
                </c:choose>
            </td>
            <td>
                <a href="editProduct?productId=${product.productId}">Edit</a>
                <!-- Add functionality for toggling status -->
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
