<%--
  Created by IntelliJ IDEA.
  User: vinh
  Date: 8/18/2024
  Time: 10:07 AM
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
    <title>Shoe shop</title>
</head>

<body>

<!-- Start Header/Navigation -->
<%@ include file="component/header.jsp" %>
<!-- End Header/Navigation -->


<h1 style="margin-left: 32px">Cart</h1>

<div class="untree_co-section before-footer-section">
    <div class="container">
        <div class="row mb-5">
            <form class="col-md-12" method="post">
                <div class="site-blocks-table">
                    <table class="table">
                        <thead>
                        <tr>

                            <th class="product-thumbnail">Image</th>
                            <th class="product-name">Product</th>
                            <th class="product-detail">Detail</th>
                            <th class="product-price">Price</th>
                            <th class="product-quantity">Quantity</th>
                            <th class="product-total">Total</th>
                            <th class="product-remove">Remove</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="cart" items="${listCart}">
                            <tr>

                                <td class="product-thumbnail">
                                    <img src="${cart.img_url}" alt="Image_Product" class="img-fluid">
                                </td>
                                <td class="product-name" >
                                    <h2 class="h5 text-black">${cart.product_name}</h2>

                                </td>
                                <td> ${cart.color_name} ,${cart.size}</td>
                                <td><fmt:formatNumber value="${cart.price}"  /> VNĐ</td>
                                <td>
                                    <div class="input-group mb-3 d-flex align-items-center quantity-container"
                                         style="max-width: 120px;">
                                        <div class="input-group-prepend">
                                            <form action="updateCart" method="post" style="display:inline;">
                                                <input type="hidden" name="cartId" value="${cart.cart_id}"/>
                                                <input type="hidden" name="quantity" value="${cart.quantity - 1}"/>
                                                <input type="hidden" name="cart_product_name" value="${cart.product_name}" />
                                                <input type="hidden" name="cart_color_name" value="${cart.color_name}" />
                                                <input type="hidden" name="cart_size" value="${cart.size}" />
                                                <button class="btn btn-outline-black decrease" type="submit">-</button>
                                            </form>
                                        </div>
                                        <input type="text" class="form-control text-center quantity-amount"
                                               value="${cart.quantity}"
                                               placeholder="" aria-label="Example text with button addon"
                                               aria-describedby="button-addon1" name="quantity" readonly>
                                        <div class="input-group-append">
                                            <form action="updateCart" method="post" style="display:inline;">
                                                <input type="hidden" name="cartId" value="${cart.cart_id}"/>
                                                <input type="hidden" name="quantity" value="${cart.quantity + 1}"/>
                                                <input type="hidden" name="cart_product_name" value="${cart.product_name}" />
                                                <input type="hidden" name="cart_color_name" value="${cart.color_name}" />
                                                <input type="hidden" name="cart_size" value="${cart.size}" />
                                                <button class="btn btn-outline-black increase" type="submit">&plus;</button>
                                            </form>
                                        </div>
                                    </div>

                                </td>
                                <td><fmt:formatNumber value="${cart.price * cart.quantity}" /> VNĐ</td>
                                <td><a href="delete?cid=${cart.cart_id}" class="btn btn-black btn-sm">X</a></td>
                            </tr>
                            <c:set var="totalCartPrice" value="${totalCartPrice + (cart.price * cart.quantity)}" />

                        </c:forEach>
                        </tbody>
                    </table>

                </div>
            </form>
            <c:if test="${not empty error}">
                <p style="color:red; font-size: 12px; margin: 10px 0 10px;">${error}</p>
            </c:if>
        </div>


        <div class="col-md-6 pl-5">

            <div class="col-md-7">
                <div class="row">
                    <div class="col-md-12 text-right border-bottom mb-5">
                        <h3 class="text-black h4 text-uppercase">Cart Totals</h3>
                    </div>
                </div>

                <div class="row mb-5">
                    <div class="col-md-6">
                        <span class="text-black">Total</span>
                    </div>
                    <div class="col-md-6 text-right">
                        <strong class="text-black"><fmt:formatNumber value="${totalCartPrice}" /> VNĐ</strong>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-12">
                        <button class="btn btn-black btn-lg py-3 btn-block"
                                onclick="window.location='cartContact'">Proceed To Checkout
                        </button>
                    </div>
                </div>
            </div>

        </div>

    </div>
</div>


<!-- Start Footer Section -->
<%@ include file="component/footer.jsp" %>
<!-- End Footer Section -->


<script src="static/css/bootstrap-5.3.3-dist/js/bootstrap.bundle.min.js"></script>
<script src="static/css/bootstrap-5.3.3-dist/js/tiny-slider.js"></script>
<script src="static/css/bootstrap-5.3.3-dist/js/custom.js"></script>

</body>

</html>
