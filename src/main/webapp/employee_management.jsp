<%--
  Created by IntelliJ IDEA.
  User: vinh
  Date: 8/12/2024
  Time: 1:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <div class="app-sidebar__user"><img class="app-sidebar__user-avatar" src="/images/hay.jpg" width="50px"
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

                            <a class="btn btn-add btn-sm" href="add_employee.jsp" title="Thêm"><i class="fas fa-plus"></i>
                                Add employee</a>
                        </div>


                    </div>
                    <table class="table table-hover table-bordered js-copytextarea" cellpadding="0" cellspacing="0" border="0"
                    >
                        <form action="/search" method="GET">


                            <div class="col-sm-12 col-md-6">
                                <div class="dataTables_length" id="sampleTable_length">
                                    <label>
                                        <select name="sampleTable_length" aria-controls="sampleTable" class="form-control form-control-sm">
                                            <option value="10">10</option>
                                        </select>
                                    </label>
                                    <label>
                                        <select name="sampleTable_length" aria-controls="sampleTable" class="form-control form-control-sm">
                                            <option value="10">10</option>
                                        </select>
                                    </label>
                                    <label>
                                        <input type="search" class="form-control form-control-sm" placeholder="" aria-controls="sampleTable">
                                    </label>
                                    <label>
                                        <button type="submit">Search</button>
                                    </label>
                                </div>
                            </div>
                        </form>


                        <thead>
                        <tr>

                            <th>ID </th>
                            <th width="130">Name</th>
                            <th width="300">Address</th>
                            <th>Email</th>
                            <th>Phone number</th>
                            <th>Role</th>
                            <th width="100">Setting</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>


                            <td>#CD12837</td>
                            <td>Hồ Thị Thanh Ngân</td>
                            <td>155-157 Trần Quốc Thảo, Quận 3, Hồ Chí Minh </td>
                            <td>abcdef@gmail.com</td>
                            <td>0926737168</td>
                            <td>Bán hàng</td>
                            <td class="table-td-center">

                                <button class="btn btn-primary btn-sm edit" type="button" title="Edit" id="show-emp"
                                        data-toggle="modal" data-target="#ModalUP"><i class="fas fa-edit"></i>
                                </button>
                            </td>
                        </tr>


                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</main>

<!--
MODAL
-->
<div class="modal fade" id="ModalUP" tabindex="-1" role="dialog" aria-hidden="true" data-backdrop="static"
     data-keyboard="false">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">

            <div class="modal-body">
                <div class="row">
                    <div class="form-group  col-md-12">
              <span class="thong-tin-thanh-toan">
                <h5>Edit employee information</h5>
              </span>
                    </div>
                </div>
                <div class="row">

                    <div class="form-group col-md-6">
                        <label class="control-label">Name</label>
                        <input class="form-control" type="text" required value="Võ Trường" disabled>
                    </div>
                    <div class="form-group  col-md-6">
                        <label class="control-label">Email</label>
                        <input class="form-control" type="text" required value="09267312388" disabled>
                    </div>
                    <div class="form-group col-md-6">
                        <label class="control-label">Phone</label>
                        <input class="form-control" type="text" required value="truong.vd2000@gmail.com" disabled>
                    </div>
                    <div class="form-group col-md-6">
                        <label class="control-label">Date of birth</label>
                        <input class="form-control" type="date" value="15/03/2000" disabled>
                    </div>
                    <div class="form-group col-md-6">
                        <label class="control-label">Address</label>
                        <input class="form-control" type="text" value="Hanoi" disabled>
                    </div>
                    <div class="form-group col-md-6">
                        <label class="control-label">Password</label>
                        <input class="form-control" type="text" value="123" >
                    </div>

                    <div class="form-group  col-md-6">
                        <label for="exampleSelect1" class="control-label">Role</label>
                        <select class="form-control" id="">
                            <option>Bán hàng</option>
                            <option>Tư vấn</option>
                            <option>Dịch vụ</option>
                            <option>Thu Ngân</option>
                            <option>Quản kho</option>
                            <option>Bảo trì</option>
                            <option>Kiểm hàng</option>
                            <option>Bảo vệ</option>
                            <option>Tạp vụ</option>
                        </select>
                    </div>
                    <div class="form-group  col-md-6">
                        <label for="exampleSelect1" class="control-label">Active</label>
                        <select class="form-control" id="exampleSelect1">
                            <option>Active</option>
                            <option>InActive</option>

                        </select>
                    </div>
                    <div class="form-group col-md-6">
                        <label class="control-label">Create date</label>
                        <input class="form-control" type="text" value="2024-08-11 07:34:41.000" disabled>
                    </div>
                    <div class="form-group col-md-6">
                        <label class="control-label">Update date</label>
                        <input class="form-control" type="text" value="2024-08-11 07:34:41.000" disabled>
                    </div>

                </div>
                <BR>
                <BR>
                <BR>
                <button class="btn btn-save" type="submit">Save</button>
                <a class="btn btn-cancel" data-dismiss="modal" href="#">Cancel</a>
                <BR>
            </div>
            <div class="modal-footer">
            </div>
        </div>
    </div>
</div>
<!--
MODAL
-->

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
        $("#ModalUP").modal({ backdrop: false, keyboard: false })
    });
</script>
</body>
</html>
