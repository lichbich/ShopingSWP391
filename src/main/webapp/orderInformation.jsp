<%--
  Created by IntelliJ IDEA.
  User: vinh
  Date: 8/22/2024
  Time: 11:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html lang="en">

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
    <title>Furni Free Bootstrap 5 Template for Furniture and Interior Design Websites by Untree.co </title>
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
                    <h1>Order Information</h1>
                </div>
            </div>
            <div class="col-lg-7">

            </div>
        </div>
    </div>
</div>
<!-- End Hero Section -->

<form method="post" action="actionOrder">
    <div class="untree_co-section before-footer-section">
        <div class="container">
            <div class="row">
                <!-- Order Information -->
                <div class="col-md-6">
                    <div class="card">
                        <div class="card-header">
                            Order Information
                        </div>
                        <div class="card-body">
                            <p><strong>Order ID:</strong> ${detail.order_id}</p>
                            <input type="hidden" name="order_id" value="${detail.order_id}">
                            <p><strong>Order Date:</strong> ${detail.order_date}</p>
                            <p><strong>Total Cost:</strong> <fmt:formatNumber value="${detail.total_price}"/> VNĐ</p>
                            <p><strong>Status:</strong> <span id="order-status">${detail.status}</span></p>

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
                            <label for="receiverName"><strong>Receiver Name:</strong></label>
                            <input type="text" id="receiverName" name="receiver_name" value="${detail.receiver_name}" class="form-control">
                            <label for="shippingAddress"><strong>Shipping Address:</strong></label>
                            <input type="text" id="shippingAddress" name="shipping_address" value="${detail.shipping_address}" class="form-control">
                            <label for="email"><strong>Email:</strong></label>
                            <input type="text" id="email" name="" value="${detail.user_email}" class="form-control" readonly>
                            <label for="receiverPhone"><strong>Receiver Phone:</strong></label>
                            <input type="text" id="receiverPhone" name="receiver_phone" value="${detail.receiver_phone}" class="form-control">

                        </div>
                    </div>
                </div>
            </div>

        </div>


        <div class="container">

            <div class="row mb-5">
                <form class="col-md-12" method="post">
                    <div class="site-blocks-table">
                        <table class="table">
                            <thead>
                            <tr>
                                <th>Image</th>
                                <th>Name</th>
                                <th>Details</th>
                                <th>Unit Price</th>
                                <th>Quantity</th>
                                <th>Total Cost</th>
                                <th>Actions</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="detail" items="${orderDetails}">
                                <tr>
                                    <td><img src="${detail.image_url}" alt="Product Image" class="product-thumbnail">
                                    </td>
                                    <td>${detail.product_name}</td>
                                    <td>${detail.color_name}, ${detail.size}</td>
                                    <td><fmt:formatNumber value="${detail.price}"/> VNĐ</td>
                                    <td>${detail.quantity}</td>
                                    <td><fmt:formatNumber value="${detail.price * detail.quantity} "/> VNĐ</td>
                                    <td>
                                        <a href="rebuy?productDetailId=${detail.product_detail_id}"
                                           class="btn btn-primary btn-sm">Re-buy</a>

                                    </td>
                                </tr>

                            </c:forEach>


                            </tbody>
                        </table>
                    </div>
                </form>
            </div>

<%--            <div id="action-buttons" class="action-buttons text-center">--%>
<%--                <button class="btn btn-black btn-lg py-3 btn-block" type="submit" name="action" value="update">Update Order</button>--%>
<%--                <button class="btn btn-black btn-lg py-3 btn-block" type="submit" name="action" value="cancel">Cancel Order</button>--%>
<%--            </div>--%>


            <div id="action-buttons-update" class="action-buttons text-center">
                <button class="btn btn-black btn-lg py-3 btn-block" type="submit" name="action" value="update">Update Order</button>

            </div>
            <br>
            <div id="action-buttons-cancel" class="action-buttons text-center">
                <button class="btn btn-black btn-lg py-3 btn-block" type="submit" name="action" value="cancel">Cancel Order</button>

            </div>


        </div>
    </div>

</form>


<!-- Start Footer Section -->
<%@ include file="component/footer.jsp" %>
<!-- End Footer Section -->


<script src="static/js/bootstrap.bundle.min.js"></script>
<script src="static/js/tiny-slider.js"></script>
<script src="static/js/custom.js"></script>
<script>
    const orderStatus = document.getElementById('order-status').innerText;
    const actionButtonsUpdate = document.getElementById('action-buttons-update');
    const actionButtonsCancel= document.getElementById('action-buttons-cancel');

    const receiverName = document.getElementById('receiverName');
    const shippingAddress = document.getElementById('shippingAddress');
    const receiverPhone = document.getElementById('receiverPhone');


    if (orderStatus === 'Shipping') {
        actionButtonsUpdate.style.display = 'none';
        receiverName.readOnly = true;
        shippingAddress.readOnly = true;
        receiverPhone.readOnly = true;
    }

    if (orderStatus === 'Done') {
        actionButtonsUpdate.style.display = 'none';
        actionButtonsCancel.style.display = 'none';
        receiverName.readOnly = true;
        shippingAddress.readOnly = true;
        receiverPhone.readOnly = true;
    }

    if (orderStatus === 'Canceled') {
        actionButtonsUpdate.style.display = 'none';
        actionButtonsCancel.style.display = 'none';
        receiverName.readOnly = true;
        shippingAddress.readOnly = true;
        receiverPhone.readOnly = true;
    }
</script>



</body>

</html>
