<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="LogIn.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
table{ margin: auto; position: absolute; top: 100px; bottom: 0px; left: 0px; right: 0px; }
</style>
<jsp:include page="/UnsetSessionServlet" flush="true" />
</head>
<body >
	<form method="POST" action="Loginservlet">
	<table style="text-align: right;">
		<tr>
			<td>User Name:</td>
			<td><input type="text" name="username" /></td>
		</tr> 
		<tr>
			<td>Password:</td>
			<td><input type="password" name="password" /></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="Login" /></td>
		</tr> 	
    </table>
    </form>
</body>
</html>