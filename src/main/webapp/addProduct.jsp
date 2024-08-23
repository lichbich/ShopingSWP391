<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
  <head>
    <title>Title</title>
    <!-- Main CSS-->
    <link rel="stylesheet" type="text/css" href="static/css/main.css" />
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

  <%@ include file="component/sideBar.jsp" %>

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
            <h3 class="tile-title">Add new product</h3>
            <div class="tile-body">
              <form class="row" action="add-product" method="post">
                <div class="form-group col-md-3">
                  <label class="control-label">Product name</label>
                  <input class="form-control" type="text" name="productName" required/>
                </div>
                <div class="form-group col-md-3">
                  <label class="control-label">Category</label>
                  <select name="CategoryID" class="form-control" >
                    <c:forEach var="category" items="${categories}">
                      <option value="${category.category_id}">${category.name}</option>
                    </c:forEach>
                  </select>
                </div>
                <div class="form-group col-md-12">
                  <label class="control-label" required>Description</label>
                  <textarea
                    class="form-control"
                    name="description"
                    id="mota"
                  ></textarea>
                </div>
                <div class="form-group col-md-12">
                  <button type="submit" class="btn btn-save">Save</button>
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
