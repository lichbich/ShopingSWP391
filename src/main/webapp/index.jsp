<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="author" content="Untree.co">
    <link rel="shortcut icon" href="favicon.png">
    <link rel="shortcut icon" href="static/favicon.png">
    <meta name="description" content=""/>
    <meta name="keywords" content="bootstrap, bootstrap4"/>

    <!-- Bootstrap CSS -->
    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
    <link href="static/css/tiny-slider.css" rel="stylesheet">
    <link href="static/css/style.css" rel="stylesheet">
    <link href="static/css/home.css" rel="stylesheet">
    <title>Furni Free Bootstrap 5 Template for Furniture and Interior Design Websites by Untree.co </title>
</head>

<script>
    document.addEventListener('DOMContentLoaded', function () {
        console.log('Products:', JSON.stringify(products));
    });
</script>

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
                    <h1>Modern Interior <span clsas="d-block">Design Studio</span></h1>
                    <p class="mb-4">Donec vitae odio quis nisl dapibus malesuada. Nullam ac aliquet velit. Aliquam
                        vulputate velit imperdiet dolor tempor tristique.</p>
                    <p><a href="" class="btn btn-secondary me-2">Shop Now</a><a href="#" class="btn btn-white-outline">Explore</a>
                    </p>
                </div>
            </div>
            <div class="col-lg-7">
                <div class="hero-img-wrap">
                    <img src="static/images/poster.jpeg" class="img-fluid">
                </div>
            </div>
        </div>
    </div>
</div>
<!-- End Hero Section -->

<form action="products" method="post" class="search-form">
    <input class="search-input" type="text" name="searchQuery" placeholder="Search for products...">
    <button type="submit">Search</button>
</form>
<!-- New Product Section -->
<div class="product-section" style="padding: 0 !important; margin-bottom: 32px !important;">

    <div class="container">
        <!-- Start Column 1 -->
        <div class="col-md-12 col-lg-3 mb-5 mb-lg-0 Category" style="margin-bottom: 32px !important;">
            <h2>New product</h2>
        </div>
        <!-- End Column 1 -->
        <div class="row">
            <!-- Start Column 2 -->
            <jsp:useBean id="latestProducts" scope="request" type="java.util.List"/>
            <c:forEach items="${latestProducts}" var="productL">
                <div class="col-12 col-md-4 col-lg-3 mb-5 product-content">
                    <a class="product-item" href="productDetail?productId=${productL.product_id}">
                        <img src="${productL.imageUrl}" class="img-fluid product-thumbnail">
                        <h3 class="product-title">${productL.product_name}</h3>
                        <p>${productL.description}</p>
                        <strong class="product-price">${productL.priceDisplay} VNĐ</strong>
                    </a>
                </div>
            </c:forEach>
            <!-- End Column 2 -->

        </div>
    </div>
</div>
<!-- New Product Section -->


<!-- Start Product Section -->
<div class="product-section" style="padding: 0 !important; margin-bottom: 32px !important;">

    <div class="productList">
        <!-- Start Column 1 -->

        <div class="col-md-12 col-lg-3 mb-5 mb-lg-0 Category">
            <h2>Category</h2>
            <jsp:useBean id="categories" scope="request" type="java.util.List"/>
            <c:forEach var="category" items="${categories}">
                <ul class="list-unstyled custom-list">
                    <li><a href="category?categoryId=${category.category_id}">${category.name}</a></li>
                </ul>
            </c:forEach>

        </div>
        <!-- End Column 1 -->
        <div class="row">
            <!-- Start Column 2 -->
            <c:forEach var="product" items="${products}">
                <div class="col-12 col-md-4 col-lg-3 mb-5 product-content">
                    <a class="product-item" href="productDetail?productId=${product.product_id}">
                        <img src="${product.imageUrl}" class="img-fluid product-thumbnail">
                        <h3 class="product-title">${product.product_name}</h3>
                        <p>${product.description}</p>
                        <strong class="product-price">${product.priceDisplay} VNĐ</strong>

                    </a>
                </div>
            </c:forEach>
            <!-- End Column 2 -->

        </div>
    </div>
</div>
<!-- End Product Section -->

<!--footer-->
<%@ include file="component/footer.jsp" %>
<!--footer-->


<script src="static/js/bootstrap.bundle.min.js"></script>
<script src="static/js/tiny-slider.js"></script>
<script src="static/js/custom.js"></script>
</body>

</html>
