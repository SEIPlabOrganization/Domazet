<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
table{ margin: auto; position: absolute; top: 100px; bottom: 0px; left: 0px; right: 0px; }
</style>
</head>
<body >
	<form method="POST" action="ChangeAccServlet">
	<table style="text-align: right;">
		<%
			if(session.getAttribute("newacc")=="yes"){
		out.write("<tr><td>New User Name:</td><td><input type='text' name='newusername' /></td></tr>");
			}%>
		<tr>
			<td>Old Password:</td>
			<td><input type="text" name="oldpassword"/></td>
		</tr>
		<tr>
		<tr>
			<td>New Password:</td>
			<td><input type="text" name="newpassword"/></td>
		</tr>
		<tr>
			<td>Repeat New Password:</td>
			<td><input type="text" name="repeatpassword"/></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="Submit" /></td>
		</tr> 	
    </table>
    </form>
</body>
</html>