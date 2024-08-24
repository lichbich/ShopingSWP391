<%--
  Created by IntelliJ IDEA.
  User: vinh
  Date: 8/23/2024
  Time: 10:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="en">

<head>
    <title>Order List</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Main CSS-->
    <link rel="stylesheet" type="text/css" href="static/css/admin.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
    <!-- or -->
    <link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">

    <!-- Font-icon css-->
    <link rel="stylesheet" type="text/css"
          href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.css">

</head>

<body class="app sidebar-mini rtl">
<!-- Navbar-->
<header class="app-header">
    <!-- Sidebar toggle button--><a class="app-sidebar__toggle" href="#" data-toggle="sidebar"
                                    aria-label="Hide Sidebar"></a>
    <!-- Navbar Right Menu-->
    <ul class="app-nav">


        <!-- User Menu-->
        <li><a class="app-nav__item" href="${pageContext.request.contextPath}/LogoutController"><i class='bx bx-log-out bx-rotate-180'></i> </a>

        </li>
    </ul>
</header>
<!-- Sidebar menu-->
<div class="app-sidebar__overlay" data-toggle="sidebar"></div>
<aside class="app-sidebar">
    <div class="app-sidebar__user">
        <div>
            <p class="app-sidebar__user-name"><b></b></p>
            <p class="app-sidebar__user-designation">Welcome back</p>
        </div>
    </div>
    <hr>
    <ul class="app-menu">


        <li><a class="app-menu__item active" href="orderManagement"><i class='app-menu__icon bx bx-id-card'></i>
            <span class="app-menu__label">Order Management</span></a></li>

    </ul>
</aside>
<main class="app-content">
    <div class="app-title">
        <ul class="app-breadcrumb breadcrumb side">
            <li class="breadcrumb-item active"><a href="orderManagement"><b>Order List</b></a></li>
        </ul>
        <div id="clock"></div>
    </div>

    <div class="row">
        <div class="col-md-12">
            <div class="tile">
                <div class="tile-body">

                    <div class="row element-button">


                    </div>
                    <table class="table table-hover table-bordered js-copytextarea" cellpadding="0" cellspacing="0" border="0">
                        <form method="get" action="orderManagement">



                            <div class="col-sm-12 col-md-6">
                                <div class="dataTables_length" id="sampleTable_length">
                                    <label>
                                        <select aria-controls="sampleTable"
                                                class="form-control form-control-sm" name="status1" onchange="this.form.submit()">
                                            <option></option>
                                            <option value="Shop Processing" ${selectedStatus == 'Shop Processing' ? 'selected' : ''}>Shop Processing</option>
                                            <option value="Shipping" ${selectedStatus == 'Shipping' ? 'selected' : ''}>Shipping</option>
                                            <option value="Done" ${selectedStatus == 'Done' ? 'selected' : ''}>Done</option>
                                            <option value="Canceled" ${selectedStatus == 'Canceled' ? 'selected' : ''}>Canceled</option>
                                        </select>
                                    </label>
<%--                                    <label>--%>
<%--                                        <input type="search" class="form-control form-control-sm" placeholder=""--%>
<%--                                               aria-controls="sampleTable">--%>
<%--                                    </label>--%>
<%--                                    <label>--%>
<%--                                        <button type="submit">Search</button>--%>
<%--                                    </label>--%>
                                </div>
                            </div>
                        </form>


                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>Ordered Name </th>
                            <th>Email</th>
                            <th>Receiver Name</th>
                            <th>Receiver Phone</th>
                            <th>Shipping Address</th>
                            <th width="300">Product</th>
                            <th width="130">Ordered Date</th>
                            <th>Total Cost</th>
                            <th>Status</th>
                            <th width="100">View</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="order" items="${orders}">
                            <tr>
                                <td>${order.order_id}</td>
                                <td>${order.user_firstname} ${order.user_lastname}</td>
                                <td>${order.user_email}</td>
                                <td>${order.receiver_name}</td>
                                <td>${order.receiver_phone}</td>
                                <td>${order.shipping_address}</td>
                                <th>${order.product_name}</th>
                                <td>${order.order_date}</td>
                                <td><fmt:formatNumber value="${order.total_price}"/> VNĐ</td>
                                <td>${order.status}</td>
                                <td class="table-td-center">
                                    <a href="orderDetailManagement?order_id=${order.order_id}" class="btn btn-black btn-sm">
                                        <button class="btn btn-primary btn-sm edit" type="button" title="View" id="show-emp"
                                                data-toggle="modal" ><i class="fas fa-edit"></i>
                                        </button>
                                    </a>

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



<!-- Essential javascripts for application to work-->
<%--<script src="js/jquery-3.2.1.min.js"></script>--%>
<%--<script src="js/popper.min.js"></script>--%>
<%--<script src="js/bootstrap.min.js"></script>--%>
<%--<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>--%>
<%--<script src="src/jquery.table2excel.js"></script>--%>
<%--<script src="js/main.js"></script>--%>
<%--<!-- The javascript plugin to display page loading on top-->--%>
<%--<script src="js/plugins/pace.min.js"></script>--%>
<%--<!-- Page specific javascripts-->--%>
<%--<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.js"></script>--%>




</body>

</html>
