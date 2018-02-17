<%@ page trimDirectiveWhitespaces="true" %>
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
            <tr></tr>
            <tr>
                <td>Current Longitude:</td>
                <td><input id="cur_longitude" name="cur_longitude"></td>
                <td>Current Latitude:</td>
                <td><input id="cur_latitude" name="cur_latitude"></td>
            </tr>
            <tr></tr>
            <tr>
                <td>Destination Longitude:</td>
                <td><input id="des_longitude" name="des_longitude"></td>
                <td>Destination Latitude:</td>
                <td><input id="des_latitude" name="des_latitude"></td>
            </tr>
            <tr></tr>
            <tr>
                <input type="checkbox" name="filter" value="normal"> Normal Car<br>
                <input type="checkbox" name="filter" value="pink" checked="checked"> Pink Car<br>
            </tr>
            <tr></tr>
            <tr>
                <td><input type="submit" value="Book Car"></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
