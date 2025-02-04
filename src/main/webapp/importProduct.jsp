<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
    <!-- Main CSS-->
    <link rel="stylesheet" type="text/css" href="static/css/main.css"/>
    <!-- Font-icon css-->
    <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css"
    />
    <!-- or -->
    <link
            rel="stylesheet"
            href="https://unpkg.com/boxicons@latest/css/boxicons.min.css"
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
    <link
            rel="stylesheet"
            type="text/css"
            href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
    />
    <script type="text/javascript" src="/ckeditor/ckeditor.js"></script>
    <script
            src="http://code.jquery.com/jquery.min.js"
            type="text/javascript"
    ></script>
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
            <a class="app-nav__item" href="/index.html"
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
                src="/images/hay.jpg"
                width="50px"
                alt="User Image"
        />
        <div>
            <p class="app-sidebar__user-designation">Chào mừng bạn trở lại</p>
        </div>
    </div>
    <hr/>
    <ul class="app-menu">
        <li>
            <a class="app-menu__item active" href="table-data-product.html"
            ><i class="app-menu__icon bx bx-purchase-tag-alt"></i
            ><span class="app-menu__label">Quản lý sản phẩm</span></a
            >
        </li>
    </ul>
</aside>
<main class="app-content">
    <div class="app-title">
        <ul class="app-breadcrumb breadcrumb">
            <li class="breadcrumb-item">Product list</li>
            <li class="breadcrumb-item"><a href="#">Add product</a></li>
        </ul>
    </div>
    <div class="row">
        <div class="col-md-12">
            <div class="tile">
                <h3 class="tile-title">Import detail product</h3>
                <div class="tile-body">
                    <div class="form-group col-md-12">
                        <label class="control-label">Import detail product</label>
                        <br/>
                        <form
                                action="import-product-detail"
                                method="post"
                                enctype="multipart/form-data"
                        >
                            <input type="file" name="file" accept=".xlsx"/>
                            <input type="submit" value="Upload" class="btn btn-save">
                        </form>

                    </div>

                </div>
            </div>
        </div>
    </div>
</main>
</body>
</html>
