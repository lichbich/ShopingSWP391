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
    <link rel="shortcut icon" href="favicon.png">

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


<div class="hero">
    <div class="container">
        <div class="row justify-content-between">
            <div class="col-lg-5">
                <div class="intro-excerpt">
                    <h1>Checkout</h1>
                </div>
            </div>
            <div class="col-lg-7">

            </div>
        </div>
    </div>
</div>
<!-- End Hero Section -->

<div class="untree_co-section">
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

                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="cart" items="${listCartContact}">
                            <tr>

                                <td class="product-thumbnail">
                                    <img src="${cart.img_url}" alt="Image" class="img-fluid">
                                </td>
                                <td class="product-name">
                                    <h2 class="h5 text-black">${cart.product_name}</h2>
                                </td>
                                <td>${cart.color_name}, ${cart.size}</td>
                                <td><fmt:formatNumber value="${cart.price}" type="currency"/></td>
                                <td>${cart.quantity} </td>
                                <td><fmt:formatNumber value="${cart.price * cart.quantity}" type="currency"/></td>

                            </tr>

                        </c:forEach>


                        </tbody>
                    </table>
                </div>
            </form>
        </div>
        <div class="container">
            <div class="row mb-5">
                <div class="col-md-12">
                    <div class="border p-4 rounded" role="alert">
                        you want to change anything? <a href="cart">Click here</a>
                    </div>
                </div>
            </div>
            <form method="post" action="order">
            <div class="row">

                    <div class="col-md-6 mb-5 mb-md-0">
                        <h2 class="h3 mb-3 text-black">Billing Details</h2>
                        <div class="p-3 p-lg-5 border bg-white">

                            <div class="col-md-12">
                                <label for="re-name" class="text-black">Name of receiver <span
                                        class="text-danger">*</span></label>
                                <input type="hidden" name="customer_id" value="${detail.user_id}"/>
                                <input type="text" value="${detail.firstname} ${detail.lastname}" class="form-control" id="re-name" name="re-name">
                            </div>

                            <div class="form-group row">
                                <div class="col-md-12">
                                    <label class="text-black">Phone number</label>
                                    <input type="text" value="${detail.phone_number}" class="form-control" name="">
                                </div>
                            </div>

                            <div class="form-group row">
                                <div class="col-md-12">
                                    <label for="address" class="text-black">Address receive <span
                                            class="text-danger">*</span></label>
                                    <input type="text" value="${detail.address}" class="form-control" id="address" name="address"
                                           placeholder="Street address">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="c_diff_country" class="text-black">Payment Method <span
                                        class="text-danger">*</span></label>
                                <select id="c_diff_country" class="form-control" name="payment">
                                    <option value="Cast">Cast</option>
                                    <option value="Bank">Bank</option>
                                    <option value="Momo">Momo</option>
                                </select>
                            </div>

                            <div class="form-group row">
                                <div class="col-md-12">
                                    <label class="text-black">Email<span class="text-danger">*</span></label>
                                    <input type="text" value="${detail.email}" class="form-control" name="" readonly>
                                </div>
                            </div>

                        </div>
                    </div>
                    <div class="col-md-6">


                        <div class="row mb-5">
                            <div class="col-md-12">
                                <h2 class="h3 mb-3 text-black">Your Order</h2>
                                <div class="p-3 p-lg-5 border bg-white">
                                    <table class="table site-block-order-table mb-5">
                                        <thead>
                                        <th>Product</th>
                                        <th>Total</th>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="cart" items="${listCartContact}">
                                            <tr>
                                                <td><strong>${cart.product_name}</strong>, ${cart.color_name}, ${cart.size}
                                                    <strong class="mx-2">x</strong> ${cart.quantity}</td>
                                                <td><fmt:formatNumber value="${cart.price * cart.quantity}"
                                                                      type="currency"/></td>
                                            </tr>
                                            <c:set var="totalCartPrice"
                                                   value="${totalCartPrice + (cart.price * cart.quantity)}"/>
                                        </c:forEach>


                                        <tr>
                                            <td class="text-black font-weight-bold"><strong>Cart Subtotal</strong></td>
                                            <td class="text-black"><fmt:formatNumber value="${totalCartPrice}"
                                                                                     type="currency"/></td>
                                        </tr>
                                        <tr>
                                            <td class="text-black font-weight-bold"><strong>Order Total</strong></td>
                                            <td class="text-black font-weight-bold"><strong><fmt:formatNumber
                                                    value="${totalCartPrice}" type="currency"/></strong></td>
                                            <input type="hidden" name="total_price" value="${totalCartPrice}"/>
                                        </tr>
                                        </tbody>
                                    </table>


                                    <div class="form-group">
                                        <button type="submit" class="btn btn-black btn-lg py-3 btn-block"
                                                onclick="window.location=''">Place Order
                                        </button>
                                    </div>

                                </div>
                            </div>
                        </div>

                    </div>


            </div>
        </form>
        </div>

        <!-- </form> -->
    </div>
</div>

<!-- Start Footer Section -->
<!-- End Footer Section -->


<script src="static/css/bootstrap-5.3.3-dist/js/bootstrap.bundle.min.js"></script>
<script src="static/css/bootstrap-5.3.3-dist/js/tiny-slider.js"></script>
<script src="static/css/bootstrap-5.3.3-dist/js/custom.js"></script>
</body>

</html>
