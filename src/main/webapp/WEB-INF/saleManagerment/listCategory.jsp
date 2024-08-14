<%@ page import="java.util.List" %>
<%@ page import="com.vn.fpt.g1.shop.dto.CategoryDto" %>
<!DOCTYPE html>
<html>
<head>
    <title>Category List</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/style.css">
</head>
<body>
<h2>Category List</h2>

<c:if test="${empty categoryList}">
    <p>No data available.</p>
</c:if>

<c:if test="${not empty categoryList}">
    <table border="1">
        <thead>
        <tr>
            <th>ID</th>
            <th>Description</th>
            <th>Status</th>
            <th>Create Date</th>
            <th>Update Date</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="category" items="${categoryList}">
            <tr>
                <td>${category.id}</td>
                <td>${category.description}</td>
                <td>${category.status}</td>
                <td>${category.createDate}</td>
                <td>${category.updateDate}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>

</body>
</html>
