<%--
  Created by IntelliJ IDEA.
  User: trung
  Date: 8/14/2024
  Time: 6:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="static/css/detail.css">
    <title>Customer Detail</title>
</head><
<body>
<h1>Customer Detail</h1>
<c:forEach items="${list}" var="o">
    <form id="employee-form" method="post" action="updateCustomerStatusServlet">
        <label for="customer-id">Customer ID:</label>
        <input type="text" id="customer-id" name="customerId" value="${o.user_id}" readonly>

        <label for="name">Name:</label>
        <input type="text" id="name" value="${o.first_name} ${o.last_name}" readonly>

        <label for="gender">Gender:</label>
        <input type="text" id="gender" value="${o.gender}" readonly>

        <label for="address">Address:</label>
        <input type="text" id="address" value="${o.address}" readonly>

        <label for="dob">Date of Birth:</label>
        <input type="text" id="dob" value="${o.dob}" readonly>

        <label for="phone">Phone Number:</label>
        <input type="text" id="phone" value="${o.phone_number}" readonly>

        <label for="email">Email:</label>
        <input type="text" id="email" value="${o.email}" readonly>

        <label for="status">Status:</label>
        <select id="status" name="status">
            <option value="1" ${o.isActive == 1 ? 'selected' : ''}>Active</option>
            <option value="0" ${o.isActive == 0 ? 'selected' : ''}>Inactive</option>
        </select>

        <button type="submit" id="save-button">Save</button>
        <button id="cancel-button">
            <a href="listCustomerServlet">Cancel</a>
        </button>
    </form>
</c:forEach>
</body>
</html>

