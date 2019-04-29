<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Avail</title>
</head>
<body>
<form  method="post" action="${pageContext.request.contextPath}/avail">
<table>
<tr>
<td>Enter restaurantid :</td>
<td>
<input type="text" id="rest" placeholder="enter for restaurant..." name="rest" >
</td>
<tr>
<td>Type of seat:</td>
<td>
<input type="text" id="seat" placeholder="Type of seat" name="seat" >
</td>
</tr>
<tr>
<td>
<button type="submit">submit</button>
</td></tr>
</table>
</form>
</body>
</html>