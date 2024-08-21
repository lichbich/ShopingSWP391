<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta
            name="viewport"
            content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <meta name="author" content="Untree.co" />
    <link rel="shortcut icon" href="favicon.png" />

    <meta name="description" content="" />
    <meta name="keywords" content="bootstrap, bootstrap4" />

    <!-- Bootstrap CSS -->
    <link href="static/css/bootstrap.min.css" rel="stylesheet" />
    <link
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"
            rel="stylesheet"
    />
    <link href="static/css/tiny-slider.css" rel="stylesheet" />
    <link href="static/css/style.css" rel="stylesheet" />
    <link href="static/css/productDetail.css" rel="stylesheet" />
    <title>
        Furni Free Bootstrap 5 Template for Furniture and Interior Design Websites
        by Untree.co
    </title>
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
                    <h1>Detail</h1>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- End Hero Section -->

<!-- Start Product Detail Section -->
<div class="we-help-section">
    <div class="container">
        <div class="row justify-content-between">
            <div class="col-lg-7 mb-5 mb-lg-0">
                <div class="imgs-grid">
                    <img
                            src="images/Pro_AV00181_2.jpeg"
                            alt="Image"
                            class="img-detail"
                    />
                </div>
            </div>
            <div class="col-lg-5 ps-lg-5">
                <h2 class="section-title mb-4">Track 6 Class E - Low Top</h2>
                <p>
                    Comfortable low-top sneakers made with Nappa Leather and Suede
                </p>
                <p>Mã sản phẩm: <strong>ALP2402</strong></p>
                <h2 class="price">1.500.000 VND</h2>
                <hr class="dotted-separator" />

                <div class="ChooseColor">
                    <h3>Color</h3>
                    <div class="color">
                        <button class="color-item green" id="green"></button>
                        <button class="color-item red" id="red"></button>
                        <button class="color-item blue" id="blue"></button>
                    </div>

                </div>

                <hr class="dotted-separator" />

                <div class="ChooseDetail">
                    <div class="ChooseDetail-size">
                        <h3>Size</h3>
                        <select
                                class="form-select"
                                aria-label="Default select example"
                                name="size"
                        >
                            <option selected>Select size</option>
                            <option value="1">One</option>
                            <option value="2">Two</option>
                            <option value="3">Three</option>
                        </select>
                    </div>

                    <div class="ChooseDetail-quantity">
                        <h3>Quantity</h3>
                        <select
                                class="form-select"
                                aria-label="Default select example"
                                name="quantity"
                        >
                            <option selected>Select quantity</option>
                            <option value="1">One</option>
                            <option value="2">Two</option>
                            <option value="3">Three</option>
                        </select>
                    </div>
                </div>

                <p><a herf="#" class="btn btn-detail">Thêm vào giỏ hàng</a></p>
            </div>
        </div>

        <div class="product-infor">
            <h2>Thông tin sản phẩm</h2>
            <p>Comfortable low-top sneakers made with Nappa Leather and Suede</p>
            <p>Color: Black</p>
            <p>Size: 39-43</p>

        </div>
    </div>
</div>

<!-- Start Product Detail Section -->
<!-- Start Footer -->
<%@ include file="component/footer.jsp" %>
<!-- End Footer -->

<script src="js/bootstrap.bundle.min.js"></script>
<script src="js/tiny-slider.js"></script>
<script src="js/custom.js"></script>
</body>
</html>
