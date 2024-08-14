<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="static/css/listCustomer.css"> <!-- Đường dẫn đến file CSS -->
    <title>List Customer</title>
</head>

<body>
<header>
    <h1>List Customer</h1>
    <form action="listCustomerServlet" method="GET">
        <div class="filters">
            <div class="filter-group">
                <label for="search-bar">Search:</label>
                <input type="text" id="search-bar" name="name" placeholder="Search by name" value="${param.name}">
            </div>
            <div class="filter-group">
                <label for="status-filter">Status:</label>
                <select id="status-filter" name="status">
                    <option value="" ${param.status == '' ? 'selected' : ''}>All Status</option>
                    <option value="active" ${param.status == 'active' ? 'selected' : ''}>Active</option>
                    <option value="inactive" ${param.status == 'inactive' ? 'selected' : ''}>Inactive</option>
                </select>
            </div>
            <button type="submit" id="search-button">Search</button>
        </div>
    </form>
</header>

<table>
    <thead>
    <tr>
        <th>Customer ID</th>
        <th>Name</th>
        <th>Gender</th>
        <th>Address</th>
        <th>Date of Birth</th>
        <th>Phone Number</th>
        <th>Email</th>
        <th>Status</th>
        <th>Features</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${usersList}" var="o">
        <tr>
            <td>${o.user_id}</td>
            <td>${o.first_name} ${o.last_name}</td>
            <td>${o.gender}</td>
            <td>${o.address}</td>
            <td>${o.dob}</td>
            <td>${o.phone_number}</td>
            <td>${o.email}</td>
            <td>
                <c:choose>
                    <c:when test="${o.isActive == 1}">
                        Active
                    </c:when>
                    <c:otherwise>
                        Inactive
                    </c:otherwise>
                </c:choose>
            </td>
            <td>
                <button class="feature-button">
                    <a href="customerDetail?cid=${o.user_id}">View/Edit</a>
                </button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<!-- Pagination (if applicable) -->
<div class="pagination">
    <a href="#" class="prev">« Prev</a>
    <a href="#" class="page-number">1</a>
    <a href="#" class="page-number">2</a>
    <a href="#" class="page-number">3</a>
    <a href="#" class="next">Next »</a>
</div>
</body>
</html>
