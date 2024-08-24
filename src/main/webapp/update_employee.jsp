<%--
  Created by IntelliJ IDEA.
  User: vinh
  Date: 8/12/2024
  Time: 1:06 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="en">


<head>
    <title>Update Employee</title>
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
    <script src="http://code.jquery.com/jquery.min.js" type="text/javascript"></script>
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
        <li><a class="app-nav__item" href="${pageContext.request.contextPath}/LogoutController"><i class='bx bx-log-out bx-rotate-180'></i> </a>

        </li>
    </ul>
</header>
<!-- Sidebar menu-->
<div class="app-sidebar__overlay" data-toggle="sidebar"></div>
<aside class="app-sidebar">
    <div class="app-sidebar__user">
        <div>
            <p class="app-sidebar__user-name"><b></b></p>
            <p class="app-sidebar__user-designation">Welcome</p>
        </div>
    </div>
    <hr>
    <ul class="app-menu">
        <li><a class="app-menu__item active" href="EmployeeManagement"><i class='app-menu__icon bx bx-id-card'></i>
            <span class="app-menu__label">Employee Management</span></a></li>
    </ul>
</aside>
<main class="app-content">
    <div class="app-title">
        <ul class="app-breadcrumb breadcrumb">
            <li class="breadcrumb-item">Employee Management</li>
            <li class="breadcrumb-item"><a href="#">Employee Information</a></li>
        </ul>
    </div>
    <div class="row">
        <div class="col-md-12">
            <div class="tile">
                <h3 class="tile-title">employee Information</h3>
                <div class="tile-body">
                    <div class="row element-button">
                        <div class="col-sm-12">

                        </div>
                    </div>
                    <form method="post" action="updateEmployee" class="row">
                        <div class="form-group col-md-4">
                            <label class="control-label">First name</label>
                            <input name="firstname" value="${detail.firstname}" class="form-control" type="text"
                                   readonly>
                        </div>
                        <div class="form-group col-md-4">
                            <label class="control-label">Last name</label>
                            <input name="lastname" value="${detail.lastname}" class="form-control" type="text" readonly>
                        </div>
                        <div class="form-group col-md-4">
                            <label class="control-label">Email</label>
                            <input name="email" value="${detail.email}" class="form-control" type="text" readonly>
                        </div>
                        <div class="form-group col-md-4">
                            <label class="control-label">Address</label>
                            <input name="address" value="${detail.address}" class="form-control" type="text" readonly>
                        </div>
                        <div class="form-group  col-md-4">
                            <label class="control-label">Phone number</label>
                            <input name="phone" value="${detail.phone_number}" class="form-control" type="text"
                                   readonly>
                        </div>
                        <div class="form-group  col-md-4">
                            <label class="control-label">Gender</label>
                            <input name="gender" value="${detail.gender}" class="form-control" type="text" readonly>
                        </div>
                        <div class="form-group  col-md-4">
                            <label class="control-label">Date of birth</label>
                            <input name="dob" value="${detail.dob}" class="form-control" type="text" readonly>
                        </div>
                        <div class="form-group  col-md-4">
                            <label class="control-label">Create time</label>
                            <input name="datecreate" value="${detail.createdate}" class="form-control" type="text"
                                   readonly>
                        </div>
                        <div class="form-group  col-md-4">
                            <label class="control-label">Last update</label>
                            <input name="dateupdate" value="${detail.updatedate}" class="form-control" type="text"
                                   readonly>
                        </div>


                        <div class="form-group  col-md-3">
                            <label for="exampleSelect1" class="control-label">Role</label>

                            <select class="form-control" id="exampleSelect1" name="role">

                                <c:forEach var="role" items="${listRole}">
                                    <option value="${role.role_id}"

                                            <c:if test="${role.role_id == detail.role_id}">
                                                selected
                                            </c:if>
                                    >
                                            ${role.role_name}


                                    </option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group  col-md-3">
                            <label for="exampleSelect1" class="control-label">Status</label>
                            <label for="exampleSelect2"></label><select class="form-control" id="exampleSelect2" name="isActive">
                                <option value="1" <c:if test="${detail.isActive == 1}">selected</c:if>>Active</option>
                                <option value="0" <c:if test="${detail.isActive == 0}">selected</c:if>>InActive</option>
                            </select>
                        </div>
                        <br>

                        <br>
                        <div style="-webkit-box-flex: 0; flex: 0 0 100%; max-width: 100%" class="form-group  col-md-6">
                            <button class="" type="submit">Save</button>
                            <a href="employeeManagement">
                                <button type="button">Cancel</button>
                            </a>

                        </div>
                    </form>

                </div>
            </div>
        </div>
    </div>
</main>


<!-- Essential javascripts for application to work-->
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/main.js"></script>
<!-- The javascript plugin to display page loading on top-->
<script src="js/plugins/pace.min.js"></script>

</body>

</html>
