<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Add Category</title>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/admin.css">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
  <link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">
  <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
  <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.css">

  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 0;
      padding: 0;
      background-color: #f4f4f4;
    }

    .app-content {
      margin-left: 250px;
      padding: 20px;
      width: calc(100% - 250px);
    }

    .app-title {
      margin-bottom: 20px;
    }

    .app-title h1 {
      margin: 0;
      font-size: 24px;
      color: #333;
    }

    .form-group {
      margin-bottom: 15px;
    }

    .form-group label {
      display: block;
      margin-bottom: 5px;
      font-weight: bold;
    }

    .form-group input,
    .form-group select {
      width: 100%;
      padding: 10px;
      border: 1px solid #ddd;
      border-radius: 4px;
      box-sizing: border-box;
    }

    .btn-submit {
      background-color: #4CAF50;
      color: white;
      border: none;
      padding: 15px 20px;
      text-align: center;
      text-decoration: none;
      display: inline-block;
      font-size: 16px;
      margin: 10px 0;
      cursor: pointer;
      border-radius: 4px;
    }

    .btn-submit:hover {
      background-color: #45a049;
    }

    .app-sidebar {
      width: 250px;
      background-color: #333;
      color: #fff;
      padding: 20px;
      height: 100vh;
      position: fixed;
    }

    .app-sidebar__user {
      display: flex;
      align-items: center;
      margin-bottom: 20px;
    }

    .app-sidebar__user-avatar {
      border-radius: 50%;
    }

    .app-sidebar__user-name {
      margin: 0;
      font-size: 16px;
    }

    .app-sidebar__user-designation {
      margin: 0;
      font-size: 14px;
    }

    .app-menu {
      list-style: none;
      padding: 0;
    }

    .app-menu__item {
      color: #fff;
      text-decoration: none;
      display: block;
      padding: 10px;
      border-radius: 4px;
      margin-bottom: 5px;
    }

    .app-menu__item.active {
      background-color: #4CAF50;
    }

    .app-menu__icon {
      margin-right: 10px;
    }
  </style>
</head>
<body class="app sidebar-mini rtl">
<header class="app-header">
  <a class="app-sidebar__toggle" href="#" data-toggle="sidebar" aria-label="Hide Sidebar"></a>
  <ul class="app-nav">
    <li><a class="app-nav__item" href="/index.html"><i class='bx bx-log-out bx-rotate-180'></i> </a></li>
  </ul>
</header>

<div class="app-sidebar__overlay" data-toggle="sidebar"></div>
<aside class="app-sidebar">
  <div class="app-sidebar__user">
    <img class="app-sidebar__user-avatar" src="/images/hay.jpg" width="50px" alt="User Image">
    <div>
      <p class="app-sidebar__user-name"><b></b></p>
      <p class="app-sidebar__user-designation">Welcome back</p>
    </div>
  </div>
  <hr>
  <ul class="app-menu">
    <li><a class="app-menu__item" href="${pageContext.request.contextPath}/categoryManager/listCategory.jsp"><i class='app-menu__icon bx bx-id-card'></i>
      <span class="app-menu__label">Category Management</span></a></li>
    <li><a class="app-menu__item active" href="#"><i class='app-menu__icon bx bx-plus'></i>
      <span class="app-menu__label">Add Category</span></a></li>
  </ul>
</aside>

<main class="app-content">
  <div class="app-title">
    <ul class="app-breadcrumb breadcrumb side">
      <li class="breadcrumb-item active"><a href="#"><b>Add New Category</b></a></li>
    </ul>
  </div>

  <form action="addCategory" method="post">
    <div class="form-group">
      <label for="description">Category Name:</label>
      <input type="text" id="description" name="description" required>
    </div>
    <div class="form-group">
      <label for="status">Status:</label>
      <select id="status" name="status" required>
        <option value="1">Active</option>
        <option value="0">Inactive</option>
      </select>
    </div>
    <button type="submit" class="btn-submit">Add Category</button>
  </form>
</main>

<script src="${pageContext.request.contextPath}/static/js/script.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.js"></script>
</body>
</html>
