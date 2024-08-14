<!DOCTYPE html>
<html>
<head>
  <title>Add Category</title>
  <link rel="stylesheet" type="text/css" href="static/css/style.css">
</head>
<body>
<h1>Add New Category</h1>
<form action="addCategory" method="post">
  <label>Description:</label>
  <input type="text" name="description" required />
  <label>Status:</label>
  <select name="status" required>
    <option value="1">Active</option>
    <option value="0">Inactive</option>
  </select>
  <button type="submit">Add Category</button>
</form>
</body>
</html>
