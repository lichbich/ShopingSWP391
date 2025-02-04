<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Product List</title>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <!-- Main CSS-->
    <link rel="stylesheet" type="text/css" href="static/css/main.css"/>
    <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css"
    />
    <!-- or -->
    <link
            rel="stylesheet"
            href="https://unpkg.com/boxicons@latest/css/boxicons.min.css"
    />

    <!-- Font-icon css-->
    <link
            rel="stylesheet"
            type="text/css"
            href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
    />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
    <link
            rel="stylesheet"
            href="https://use.fontawesome.com/releases/v5.8.2/css/all.css"
    />
    <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.css"
    />
</head>
<body>
<!-- Navbar-->
<header class="app-header">
    <!-- Sidebar toggle button--><a
        class="app-sidebar__toggle"
        href="#"
        data-toggle="sidebar"
        aria-label="Hide Sidebar"
></a>
    <!-- Navbar Right Menu-->
    <ul class="app-nav">
        <!-- User Menu-->
        <li>
            <a class="app-nav__item" href="LogoutController"
            ><i class="bx bx-log-out bx-rotate-180"></i>
            </a>
        </li>
    </ul>
</header>
<!-- Sidebar menu-->
<div class="app-sidebar__overlay" data-toggle="sidebar"></div>
<aside class="app-sidebar">
    <div class="app-sidebar__user">
        <img
                class="app-sidebar__user-avatar"
                src="static/images/user.png"
                width="50px"
                alt="User Image"
        />
        <div>
            <p class="app-sidebar__user-designation">Welcome back!</p>
        </div>
    </div>
    <hr/>
    <ul class="app-menu">
        <li>
            <a class="app-menu__item" href="productManagement"
            ><i class="app-menu__icon bx bx-purchase-tag-alt"></i
            ><span class="app-menu__label">Product Management</span></a
            >
        </li>
    </ul>
</aside>
</body>
</html>
