<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

    <!-- Static content -->
    <link rel="stylesheet" href="/resources/css/style.css">
    <script type="text/javascript" src="/resources/js/app.js"></script>

    <title>Fuber</title>
</head>
<body>
<h1>FuberApp</h1>
<div class="form">
    <form action="book_car" method="post" onsubmit="return validate()">
        <table>
            <tr>
                <td>Enter Name:</td>
                <td><input id="name" name="name"></td>
            </tr>
            <tr>
                <td>Longitude:</td>
                <td><input id="longitude" name="longitude"></td>
            </tr>
            <tr>
                <td>Latitude:</td>
                <td><input id="latitude" name="latitude"></td>
            </tr>
            <tr>
                <td><input type="submit" value="Book Car"></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
