<%--
  Created by IntelliJ IDEA.
  User: vinh
  Date: 8/23/2024
  Time: 10:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="en">

<head>
    <title>Order detail</title>
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
        <li><a class="app-nav__item" href="${pageContext.request.contextPath}/LogoutController"><i
                class='bx bx-log-out bx-rotate-180'></i> </a>

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
            <li class="breadcrumb-item active"><a href="#"><b>Order Information</b></a></li>
        </ul>
        <div id="clock"></div>
    </div>
    <form method="post" action="updateOrderStatus">
        <div class="row">
            <div class="col-md-12">
                <div class="tile">
                    <div class="tile-body">

                        <div class="row element-button">

                            <!-- Order Information -->
                            <div class="col-md-6">
                                <div class="card">
                                    <div class="card-header">
                                        Order Information
                                    </div>
                                    <div class="card-body">
                                        <input type="hidden" name="orderId" value="${detail.order_id}"/>
                                        <input type="hidden" name="currentStatus" value="${detail.status}" />
                                        <p><strong>Order ID:</strong> ${detail.order_id}</p>
                                        <p><strong>Order Date:</strong> ${detail.order_date}</p>
                                        <p><strong>Total Cost:</strong> <fmt:formatNumber
                                                value="${detail.total_price}"/> VNĐ</p>

                                        <p><strong>Status:</strong>
                                            <span id="order-status">
                        <select id="status-select" name="status" aria-controls="sampleTable"
                                class="form-control form-control-sm" onchange="this.form.submit()">
                          <option value="Shop Processing"
                                  <c:if test="${detail.status == 'Shop Processing'}">
                                      selected
                                  </c:if>
                          >Shop Processing</option>
                          <option value="Shipping"
                                  <c:if test="${detail.status == 'Shipping'}">
                                      selected
                                  </c:if>
                          >Shipping</option>
                          <option value="Done"
                                  <c:if test="${detail.status == 'Done'}">
                                      selected
                                  </c:if>
                          >Done</option>
                          <option value="Canceled"
                                  <c:if test="${detail.status == 'Canceled'}">
                                      selected
                                  </c:if>
                          >Canceled</option>
                        </select>
                                            </span>
                                        </p>
<%--                                        <div id="action-buttons" class="action-buttons text-center">--%>
<%--                                            <button type="submit">Update</button>--%>

<%--                                        </div>--%>


                                    </div>
                                </div>
                            </div>

                            <!-- Receiver Information -->
                            <div class="col-md-6">
                                <div class="card">
                                    <div class="card-header">
                                        Receiver Information
                                    </div>
                                    <div class="card-body">
                                        <p><strong>Full Name:</strong> ${detail.receiver_name}</p>
                                        <p><strong>Address:</strong>${detail.shipping_address}</p>
                                        <p><strong>Email:</strong> ${detail.user_email}</p>
                                        <p><strong>Mobile:</strong> ${detail.receiver_phone}</p>
                                    </div>
                                </div>
                            </div>


                        </div>

                        <table class="table table-hover table-bordered js-copytextarea" cellpadding="0" cellspacing="0"
                               border="0">


                            <thead>
                            <tr>
                                <th>Thumbnail</th>
                                <th>Name</th>
                                <th>Details</th>
                                <th>Unit Price</th>
                                <th>Quantity</th>
                                <th>Total Cost</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="detail" items="${orderDetails}">
                                <input type="hidden" name="productDetailId" value="${detail.product_detail_id}"/>
                                <input type="hidden" name="orderQuantity" value="${detail.quantity}"/>
                                <tr>

                                    <td><img src="${detail.image_url}" alt="Product Image" class="product-thumbnail" style="width: 150px;height: 150px">
                                    </td>
                                    <td>${detail.product_name}</td>
                                    <td>${detail.color_name}, ${detail.size}</td>
                                    <td><fmt:formatNumber value="${detail.price}"/> VNĐ</td>
                                    <td>${detail.quantity}</td>
                                    <td><fmt:formatNumber value="${detail.price * detail.quantity} "/> VNĐ</td>
                                </tr>
                            </c:forEach>


                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </form>


</main>


<!-- Essential javascripts for application to work-->
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="src/jquery.table2excel.js"></script>
<script src="js/main.js"></script>
<!-- The javascript plugin to display page loading on top-->
<script src="js/plugins/pace.min.js"></script>
<!-- Page specific javascripts-->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.js"></script>
<script>
    document.addEventListener("DOMContentLoaded", function () {
        var statusSelect = document.getElementById('status-select');
        var currentStatus = statusSelect.value;


        function updateStatusOptions() {
            switch (currentStatus) {
                case 'Shop Processing':
                    statusSelect.querySelector('option[value="Shipping"]').disabled = false;
                    statusSelect.querySelector('option[value="Canceled"]').disabled = false;
                    statusSelect.querySelector('option[value="Done"]').disabled = true;
                    break;
                case 'Shipping':
                    statusSelect.querySelector('option[value="Shop Processing"]').disabled = true;
                    statusSelect.querySelector('option[value="Canceled"]').disabled = true;
                    statusSelect.querySelector('option[value="Done"]').disabled = false;
                    break;
                case 'Done':
                    statusSelect.disabled = true;

                    break;
                case 'Canceled':
                    statusSelect.disabled = true;

                    break;
            }
        }

        updateStatusOptions();

        statusSelect.addEventListener('change', function () {
            currentStatus = statusSelect.value;
            updateStatusOptions();
        });
    });
</script>

</body>

</html>
