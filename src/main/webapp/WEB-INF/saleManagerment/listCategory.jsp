<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Category Management</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/admin.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
    <link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">
    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.css">
    <style>
        .toggle-switch {
            position: relative;
            display: inline-block;
            width: 60px;
            height: 34px;
        }

        .toggle-switch input {
            opacity: 0;
            width: 0;
            height: 0;
        }

        .slider {
            position: absolute;
            cursor: pointer;
            top: 0;
            left: 0;
            right: 0;
            bottom: 0;
            background-color: #ccc;
            transition: .4s;
            border-radius: 34px;
        }

        .slider:before {
            position: absolute;
            content: "";
            height: 26px;
            width: 26px;
            border-radius: 50%;
            left: 4px;
            bottom: 4px;
            background-color: white;
            transition: .4s;
        }

        input:checked + .slider {
            background-color: #4CAF50;
        }

        input:checked + .slider:before {
            transform: translateX(26px);
        }

        .status-active {
            color: #4CAF50;
        }

        .status-inactive {
            color: #dc3545;
        }
    </style>

    <script>
        function toggleStatus(categoryId, currentStatus) {
            const newStatus = currentStatus === 1 ? 0 : 1;
            const url = `${pageContext.request.contextPath}/changeStatus?categoryId=${categoryId}&status=${newStatus}`;

            fetch(url, { method: 'GET' })
                .then(response => {
                    if (response.ok) {
                        return response.text(); // Read response body if necessary
                    } else {
                        throw new Error('Failed to change status');
                    }
                })
                .then(data => {
                    location.reload(); // Reload page to reflect changes
                })
                .catch(error => {
                    console.error('Error:', error);
                    alert('Failed to change status');
                });
        }
    </script>
</head>
<body class="app sidebar-mini rtl">
<header class="app-header">
    <a class="app-sidebar__toggle" href="#" data-toggle="sidebar" aria-label="Hide Sidebar"></a>
    <ul class="app-nav">
        <li><a class="app-nav__item" href="/index.html"><i class='bx bx-log-out bx-rotate-180'></i> </a></li>
    </ul>
</header>

<div class="app-sidebar__overlay" data-toggle="sidebar"></div>
<aside class="app-sidebar">
    <div class="app-sidebar__user">
        <img class="app-sidebar__user-avatar" src="/images/hay.jpg" width="50px" alt="User Image">
        <div>
            <p class="app-sidebar__user-name"><b></b></p>
            <p class="app-sidebar__user-designation">Welcome back</p>
        </div>
    </div>
    <hr>
    <ul class="app-menu">
        <li><a class="app-menu__item active" href="#"><i class='app-menu__icon bx bx-id-card'></i>
            <span class="app-menu__label">Category Management</span></a></li>
    </ul>
</aside>

<main class="app-content">
    <div class="app-title">
        <ul class="app-breadcrumb breadcrumb side">
            <li class="breadcrumb-item active"><a href="#"><b>Category Management</b></a></li>
        </ul>
        <div id="clock"></div>
    </div>

    <!-- Filter and Search Form -->
    <form action="${pageContext.request.contextPath}/listCategory" method="get">
        <div class="row">
            <div class="col-md-3">
                <div class="form-group">
                    <label for="searchName">Search by Name</label>
                    <input type="text" id="searchName" name="searchName" class="form-control" value="${param.searchName}">
                </div>
            </div>
            <div class="col-md-3">
                <div class="form-group">
                    <label for="statusFilter">Filter by Status</label>
                    <select id="statusFilter" name="statusFilter" class="form-control">
                        <option value="">All</option>
                        <option value="1" ${param.statusFilter == '1' ? 'selected' : ''}>Active</option>
                        <option value="0" ${param.statusFilter == '0' ? 'selected' : ''}>Inactive</option>
                    </select>
                </div>
            </div>
            <div class="col-md-3">
                <div class="form-group">
                    <label>&nbsp;</label>
                    <button type="submit" class="btn btn-primary btn-block">Apply Filters</button>
                </div>
            </div>
        </div>
    </form>

    <div class="row">
        <div class="col-md-12">
            <div class="tile">
                <div class="tile-body">
                    <div class="row element-button">
                        <div class="col-sm-2">
                            <a class="btn btn-add btn-sm" href="${pageContext.request.contextPath}/addCategory" title="Add"><i class="fas fa-plus"></i>
                                Add Category</a>
                        </div>
                    </div>
                    <table class="table table-hover table-bordered">
                        <thead>
                        <tr>
                            <th width="50">ID</th>
                            <th>Category Name</th>
                            <th>Status</th>
                            <th>Create Date</th>
                            <th>Update Date</th>
                            <th width="100">Actions</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="category" items="${categoryList}">
                            <tr>
                                <td>${category.categoryId}</td>
                                <td>${category.description}</td>
                                <td>
                                    <label class="toggle-switch">
                                        <input type="checkbox"
                                            ${category.status == 1 ? 'checked' : ''}
                                               onclick="toggleStatus(${category.categoryId}, ${category.status})">
                                        <span class="slider"></span>
                                    </label>
                                    <c:choose>
                                        <c:when test="${category.status == 1}">
                                            <span class="status-active">Active</span>
                                        </c:when>
                                        <c:otherwise>
                                            <span class="status-inactive">Inactive</span>
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                                <td><fmt:formatDate value="${category.createDate}" pattern="dd/MM/yyyy"/></td>
                                <td><fmt:formatDate value="${category.updateDate}" pattern="dd/MM/yyyy"/></td>
                                <td class="table-td-center">
                                    <a class="btn btn-edit btn-sm" href="${pageContext.request.contextPath}/editCategory?categoryId=${category.categoryId}" title="Edit"><i class="fas fa-edit"></i></a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</main>

<script src="${pageContext.request.contextPath}/static/js/script.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.js"></script>
</body>
</html>
