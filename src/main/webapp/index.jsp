<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    if(session.getAttribute("user") == null){
        response.sendRedirect("login.jsp");
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>

    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>

<!-- Bootstrap JS, Popper.js, và jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<body>
<h1><%= "Hello World! helo" %>
</h1>
<br/>
<a href="hello-servlet"><button type="button" class="btn btn-primary" >Hello Servlet db</button></a>
<a href="logout"><button type="button" class="btn btn-secondary">Logout</button></a>
<%--<a href="login.jsp"><button type="button" class="btn btn-success">Login</button></a>--%>
</body>
</html>