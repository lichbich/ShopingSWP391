<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Product List</title>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <!-- Main CSS-->
    <link rel="stylesheet" type="text/css" href="static/css/main.css" />
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

<body class="app sidebar-mini rtl">

<%@ include file="component/sideBar.jsp" %>

<main class="app-content">
    <div class="app-title">
        <ul class="app-breadcrumb breadcrumb side">
            <li class="breadcrumb-item active">
                <a href="#"><b>Product list</b></a>
            </li>
        </ul>
        <div>
            <button class="btn btn-save"><a href="add-product">Add product</a></button>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <div class="tile">
                <div class="tile-body">
                    <table class="table table-hover table-bordered" id="sampleTable">
                        <thead>
                        <tr>
                            <th>Product ID</th>
                            <th>Product Name</th>
                            <th>Description</th>
                            <th>Action</th>
                        </tr>
                        </thead>

                        <tbody>
                <c:forEach var="product" items="${products}">
                        <tr>
                            <td>${product.product_id}</td>
                            <td>${product.product_name}</td>
                            <td>${product.description}</td>
                            <td>
                                <button
                                        class="btn btn-primary btn-sm trash"
                                        type="button"
                                        title="Xóa"
<%--                                        onclick="location.href='deleteProduct?productDetailId=${product.product_id}'"--%>
                                >
                                    <i class="fas fa-trash-alt"></i>
                                </button>
                                <button
                                        class="btn btn-primary btn-sm edit"
                                        type="button"
                                        title="Sửa"
                                        onclick="location.href='update-product?productId=${product.product_id}'"
                                >
                                    <i class="fa fa-edit"></i>
                                </button>
                            </td>
                        </tr>
                </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</main>

</body>
</html>
