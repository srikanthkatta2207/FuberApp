<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>FuberApp</title>
</head>
<body>
<h1>FuberApp</h1>
<hr>
<h2>Welcome ${customerName}</h2>
<h2>Your nearset Car is: ${car.getNumber()}</h2>
</body>
</html>
