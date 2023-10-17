<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Homepage</title>
</head>
<body>
<form action="addFarmer" method="post">
			<input type="text" name="name" placeholder="Enter Name here" class="form-control"> <br> <br>
			<input type="text" name="address" placeholder="Enter Address" class="form-control"> <br> <br>
			<input type="text" name="phone" placeholder="Enter phone number" class="form-control"> <br> <br>
		
			<input type="submit" value="submit" id="submitBtn" class="btn btn-primary">
</form>
</body>
</html>