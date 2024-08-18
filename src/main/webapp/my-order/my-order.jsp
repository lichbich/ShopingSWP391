<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Shopping</title>
    <!-- Importing all ui libs -->
    <link href="./static/assets/assets/css/font-awesome.css" rel="stylesheet"/>
    <link href="./static/assets/assets/css/style.css" rel="stylesheet"/>
    <link href="./static/assets/css/bootstrap.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="./static/assets/css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <script type="text/javascript" src="./static/assets/js/jquery-2.1.4.min.js"></script>
    <script src="./static/assets/js/simpleCart.min.js"></script>
    <script type="text/javascript" src="./static/assets/js/bootstrap-3.1.1.min.js"></script>
    <link href='https://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Lato:400,100,100italic,300,300italic,400italic,700,900,900italic,700italic'
          rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
          integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
    <script src="./static/assets/js/jquery.easing.min.js"></script>
    <script src="./static/js/jquery-3.2.1.min.js"></script>
    <script src='../../../../../../ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js'></script>
    <script src="../../../../../../m.servedby-buysellads.com/monetization.js" type="text/javascript"></script>
</head>
<body>
<div class="ban-top">
    <div class="container">
        <div class="top_nav_left">
            <nav class="navbar navbar-default">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                                data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                            <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span
                                class="icon-bar"></span> <span class="icon-bar"></span>
                        </button>
                    </div>
                    <jsp:include page="../templates/header.jsp"/>
                </div>
            </nav>
        </div>
        <div class="clearfix"></div>
    </div>
</div>
<div class="page-head">
    <div class="container">
        <h3>My Orders</h3>
    </div>
</div>
<div class="checkout">
    <div class="container">
        <div class="table-responsive">
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th>Order No</th>
                    <th>Status</th>
                    <th>Order Date</th>
                    <th>Receiver</th>
                    <th>Phone</th>
                    <th>Address</th>
                    <th>Total Price</th>
                    <th></th>
                </tr>
                </thead>
                <%
                    int index = 1;
                %>
                <c:forEach var="order" items="${order}">

                    <tr class="rem1">
                        <td class="invert"><%=index++%>
                        </td>
                        <td>
                            <c:if test="order.status == 'Completed'">
                                <span class="badge bg-${order.status == 'Completed' ? 'success' : 'danger'}">
                            <strong>${order.status}</strong>
                        </span>
                            </c:if>
                        </td>
                        <td class="invert">${order.orderDate}</td>
                        <td class="invert">${order.receiverName}</td>
                        <td class="invert">${order.receiverPhone}</td>
                        <td class="invert">${order.shippingAddress}</td>
                        <td class="invert">${order.totalPrice}</td>
                        <td class="invert"></td>
                    </tr>
                </c:forEach>

            </table>
            <div>
                <jsp:useBean id="pagination" scope="request" type="com.vn.fpt.g1.shop.common.Pagination"/>
                <c:if test="${pagination.page > 1}">
                    <a href="?page=${pagination.page - 1}&size=${pagination.size}">Previous</a>
                </c:if>

                Page ${pagination.page} of ${pagination.totalPages}

                <c:if test="${pagination.page < pagination.totalPages}">
                    <a href="?page=${pagination.page + 1}&size=${pagination.size}">Next</a>
                </c:if>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../templates/footer.jsp"/>

</body>
</html>