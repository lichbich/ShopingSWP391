
<%--
  Created by IntelliJ IDEA.
  User: vinh
  Date: 8/12/2024
  Time: 1:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Employee Management</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Main CSS-->
    <link rel="stylesheet" type="text/css" href="static/css/admin.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
    <!-- or -->
    <link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">

    <!-- Font-icon css-->
    <link rel="stylesheet" type="text/css"
          href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.css">
</head>
<body class="app sidebar-mini rtl">
<!-- Navbar-->
<header class="app-header">
    <!-- Sidebar toggle button--><a class="app-sidebar__toggle" href="#" data-toggle="sidebar"
                                    aria-label="Hide Sidebar"></a>
    <!-- Navbar Right Menu-->
    <ul class="app-nav">


        <!-- User Menu-->
        <li><a class="app-nav__item" href="/index.html"><i class='bx bx-log-out bx-rotate-180'></i> </a>

        </li>
    </ul>
</header>
<!-- Sidebar menu-->
<div class="app-sidebar__overlay" data-toggle="sidebar"></div>
<aside class="app-sidebar">
    <div class="app-sidebar__user"><img class="app-sidebar__user-avatar" src="" width="50px"
                                        alt="User Image">
        <div>
            <p class="app-sidebar__user-name"><b></b></p>
            <p class="app-sidebar__user-designation">Welcome back</p>
        </div>
    </div>
    <hr>
    <ul class="app-menu">


        <li><a class="app-menu__item active" href=""><i class='app-menu__icon bx bx-id-card'></i>
            <span class="app-menu__label">Employee Management</span></a></li>

    </ul>
</aside>
<main class="app-content">
    <div class="app-title">
        <ul class="app-breadcrumb breadcrumb side">
            <li class="breadcrumb-item active"><a href="#"><b>Employee Management</b></a></li>
        </ul>
        <div id="clock"></div>
    </div>

    <div class="row">
        <div class="col-md-12">
            <div class="tile">
                <div class="tile-body">

                    <div class="row element-button">
                        <div class="col-sm-2">

                            <a class="btn btn-add btn-sm" href="addemployee" title="Thêm"><i
                                    class="fas fa-plus"></i>
                                Add employee</a>
                        </div>


                    </div>
                    <table class="table table-hover table-bordered js-copytextarea" cellpadding="0" cellspacing="0"
                           border="0"
                    >
                        <form method="get" action="search" >


                            <div class="col-sm-12 col-md-6">
                                <div class="dataTables_length" id="sampleTable_length">
                                    <label>
                                        <select  aria-controls="sampleTable"
                                                class="form-control form-control-sm" name="role">
                                            <option value="all">All</option>
                                            <c:forEach var="role" items="${listRole}">
                                                <option value="${role.role_id}" <%= "${role.role_id}".equals(request.getAttribute("selectedRole")) ? "selected" : "" %>>${role.role_name}</option>
                                            </c:forEach>

                                        </select>
                                    </label>
                                    <label>
                                        <select aria-controls="sampleTable"
                                                class="form-control form-control-sm" name="status">
                                            <option value="all">All</option>
                                            <option value="1" <%= "1".equals(request.getAttribute("selectedStatus")) ? "selected" : "" %>>Active</option>
                                            <option value="0" <%= "0".equals(request.getAttribute("selectedStatus")) ? "selected" : "" %>>InActive</option>

                                        </select>
                                    </label>
                                    <label>
                                        <input type="text" class="form-control form-control-sm" placeholder="" aria-controls="sampleTable" name="txtSearch" value="<%= request.getAttribute("searchedName") != null ? request.getAttribute("searchedName") : "" %>">
                                    </label>
                                    <label>
                                        <button type="submit">Search</button>
                                    </label>
                                </div>
                            </div>
                        </form>


                        <thead>
                        <tr>


                            <th width="180">Name</th>
                            <th width="250">Address</th>
                            <th>Email</th>
                            <th>Phone number</th>
                            <th>Role</th>
                            <th width="100">Setting</th>
                        </tr>
                        </thead>

                        <tbody>
                        <c:forEach var="employee" items="${listE}">
                            <tr>

                                <td>${employee.firstname} ${employee.lastname}</td>
                                <td>${employee.address}</td>
                                <td>${employee.email}</td>
                                <td>${employee.phone_number}</td>
                                <td>${employee.rolename}</td>
                                <td class="table-td-center">
                                    <a href="loadEmployee?eid=${employee.user_id}">

                                        <button class="btn btn-primary btn-sm edit" type="button" title="Edit"
                                                id="show-emp"
                                                data-toggle="modal" data-target="#ModalUP"><i class="fas fa-edit"></i>
                                        </button>
                                    </a>
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


<!-- Essential javascripts for application to work-->
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="src/jquery.table2excel.js"></script>
<script src="js/main.js"></script>
<!-- The javascript plugin to display page loading on top-->
<script src="js/plugins/pace.min.js"></script>
<!-- Page specific javascripts-->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.js"></script>
<!-- Data table plugin-->
<script type="text/javascript" src="js/plugins/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="js/plugins/dataTables.bootstrap.min.js"></script>
<script>
    $("#show-emp").on("click", function () {
        $("#ModalUP").modal({backdrop: false, keyboard: false})
    });
</script>
</body>
</html>
