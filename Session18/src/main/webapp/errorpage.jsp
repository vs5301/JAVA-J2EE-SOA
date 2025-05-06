<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>ERROR</title>
	</head>
	<body>
		<h3>OOPS!! Something Went Wrong !</h3>
		
		<!-- exception is reference variable to Eception Object > available as implicit access -->
		Message: <%= exception %>
	</body>
</html>