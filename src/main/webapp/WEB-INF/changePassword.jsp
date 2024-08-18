<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Change Password</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/changePassword.css">
</head>
<body>
<div class="container">
  <h2>Change Password</h2>

  <c:if test="${not empty errorMessage}">
    <div class="alert error">${errorMessage}</div>
  </c:if>

  <c:if test="${not empty successMessage}">
    <div class="alert success">${successMessage}</div>
  </c:if>

  <form action="${pageContext.request.contextPath}/changePassword" method="post">
    <div class="form-group">
      <label for="currentPassword">Current Password:</label>
      <input type="password" id="currentPassword" name="currentPassword" required>
    </div>
    <div class="form-group">
      <label for="newPassword">New Password:</label>
      <input type="password" id="newPassword" name="newPassword" required>
    </div>
    <div class="form-group">
      <label for="confirmPassword">Confirm New Password:</label>
      <input type="password" id="confirmPassword" name="confirmPassword" required>
    </div>
    <button type="submit" class="btn btn-primary">Change Password</button>
  </form>
</div>
</body>
</html>
