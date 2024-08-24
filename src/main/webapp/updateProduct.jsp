<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Update Product</title>
    <!-- Main CSS-->
    <link rel="stylesheet" type="text/css" href="static/css/main.css"/>
</head>
<body class="app sidebar-mini rtl">

<%@ include file="component/sideBar.jsp" %>

<main class="app-content">
    <div class="app-title">
        <ul class="app-breadcrumb breadcrumb">
            <li class="breadcrumb-item">Product list</li>
            <li class="breadcrumb-item"><a href="#">Update product</a></li>
        </ul>
    </div>
    <div class="row">
        <div class="col-md-12">
            <div class="tile">
                <h3 class="tile-title">Update Product</h3>
                <div class="tile-body">
                    <form class="row" action="update-product" method="post">
                        <input type="hidden" name="productId" value="${product.product_id}"/>
                        <div class="form-group col-md-3">
                            <label class="control-label">Product name</label>
                            <input class="form-control" type="text" name="productName" value="${product.product_name}"/>
                        </div>
                        <div class="form-group col-md-3">
                            <label class="control-label">Category</label>
                            <select name="CategoryID" class="form-control">
                                <c:forEach var="category" items="${categories}">
                                    <option value="${category.category_id}" <c:if test="${category.category_id == product.category_id}">selected</c:if>>${category.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group col-md-12">
                            <label class="control-label">Description</label>
                            <textarea class="form-control" name="description">${product.description}</textarea>
                        </div>
                        <div class="form-group col-md-12">
                            <button type="submit" class="btn btn-primary">Update</button>
                            <a class="btn btn-cancel" href="productManagement">Cancel</a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</main>
</body>
</html>