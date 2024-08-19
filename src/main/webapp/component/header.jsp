<%--
  Created by IntelliJ IDEA.
  User: BasHuw
  Date: 8/8/2024
  Time: 9:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
    <link href="static/css/tiny-slider.css" rel="stylesheet">
    <link href="static/css/style.css" rel="stylesheet">
    <link rel="shortcut icon" href="favicon.png">
</head>
<body>
<!-- Start Header/Navigation -->
<nav class="custom-navbar navbar navbar navbar-expand-md navbar-dark bg-dark" arial-label="Furni navigation bar">

    <div class="container">
        <a class="navbar-brand" href="index.html">Furni<span>.</span></a>

        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarsFurni" aria-controls="navbarsFurni" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarsFurni">
            <ul class="custom-navbar-nav navbar-nav ms-auto mb-2 mb-md-0">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/index.jsp">Home</a>
                </li>
                <li><a class="nav-link active" href="${pageContext.request.contextPath}/products">Shop</a></li>
                <li><a class="nav-link" href="#">About us</a></li>
                <li><a class="nav-link" href="#">Blog</a></li>
            </ul>

            <ul class="custom-navbar-cta navbar-nav mb-2 mb-md-0 ms-5">
                <li><a class="nav-link" href="#"><i class="fa-regular fa-user"></i></a></li>
                <li><a class="nav-link" href="cart.html"><i class="fa-solid fa-cart-shopping"></i></a></li>
                <li><a class="nav-link" href="/logout">Log out</a></li>
            </ul>
        </div>
    </div>

</nav>
<!-- End Header/Navigation -->

<script>
    // Highlight the active link
    document.addEventListener('DOMContentLoaded', function() {
        var path = window.location.pathname;
        var page = path.split("/").pop();
        var navLinks = document.querySelectorAll('.nav-link');
        navLinks.forEach(function(link) {
            if (link.getAttribute('href') === page) {
                link.style.color = 'white';
            }
        });
    });
</script>
</body>
</html>
