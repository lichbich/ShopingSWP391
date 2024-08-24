<%--
  Created by IntelliJ IDEA.
  User: vinh
  Date: 8/22/2024
  Time: 3:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="author" content="Untree.co">
    <link rel="shortcut icon" href="">

    <meta name="description" content=""/>
    <meta name="keywords" content="bootstrap, bootstrap4"/>

    <!-- Bootstrap CSS -->
    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
    <link href="static/css/tiny-slider.css" rel="stylesheet">
    <link href="static/css/style.css" rel="stylesheet">
    <title>You order list </title>
</head>
<body>
<!-- Start Header/Navigation -->
<%@ include file="component/header.jsp" %>
<!-- End Header/Navigation -->

<!-- Start Hero Section -->
<div class="hero">
    <div class="container">
        <div class="row justify-content-between">
            <div class="col-lg-5">
                <div class="intro-excerpt">
                    <h1>Order List</h1>
                </div>
            </div>
            <div class="col-lg-7">

            </div>
        </div>
    </div>
</div>
<!-- End Hero Section -->

<div class="untree_co-section before-footer-section">
    <div class="container">
        <div class="row mb-5">

            <div class="site-blocks-table">
                <table class="table">
                    <form method="get" action="customerListOrder">

                        <div class="col-sm-12 col-md-6">
                            <div class="dataTables_length" id="sampleTable_length">
                                <label>
                                    <select aria-controls="sampleTable"
                                            class="form-control form-control-sm" name="status" onchange="this.form.submit()">
                                        <option></option>
                                        <option value="Shop Processing" ${selectedStatus == 'Shop Processing' ? 'selected' : ''}>Shop Processing</option>
                                        <option value="Shipping" ${selectedStatus == 'Shipping' ? 'selected' : ''}>Shipping</option>
                                        <option value="Done" ${selectedStatus == 'Done' ? 'selected' : ''}>Done</option>
                                        <option value="Canceled" ${selectedStatus == 'Canceled' ? 'selected' : ''}>Canceled</option>

                                    </select>
                                </label>

                            </div>
                        </div>
                    </form>
                    <thead>
                    <tr>
                        <th>Product</th>
                        <th>Ordered Date</th>
                        <th>Total Cost</th>
                        <th>Status</th>
                        <th>View</th>

                    </tr>

                    </thead>
                    <tbody>
                    <c:forEach var="order" items="${orders}">
                        <tr>
                            <td>${order.product_name}</td>
                            <td>${order.order_date}</td>
                            <td><fmt:formatNumber value="${order.total_price}"/> VNĐ</td>
                            <td>${order.status}</td>
                            <td><a href="orderInformation?order_id=${order.order_id}" class="btn btn-black btn-sm">
                                <button class="btn btn-primary btn-sm edit" type="button" title="View" id="show-emp"
                                        data-toggle="modal" data-target=""><i class="fas fa-edit"></i>
                                </button>
                            </a></td>
                        </tr>

                    </c:forEach>



                    </tbody>
                </table>
            </div>

        </div>


    </div>
</div>

<!-- Start Footer Section -->
<%@ include file="component/footer.jsp" %>
<!-- End Footer Section -->


<script src="static/js/bootstrap.bundle.min.js"></script>
<script src="static/js/tiny-slider.js"></script>
<script src="static/js/custom.js"></script>

</body>
</html>
