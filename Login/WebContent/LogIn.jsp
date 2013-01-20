<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>

<html>
<head>
<link rel="stylesheet" href="LogIn.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
*{ margin: 0px; padding: 0px}
table, body, html{ width: 100%; height: 100%; }
</style>
<script type="text/javascript">
	<!--
		if (top.location!= self.location) {
			top.location = self.location.href
		}
		if(document.URL!="http://localhost:8080/Login/Frame.jsp")
			location.href="http://localhost:8080/Login/Frame.jsp";
	//-->
	</script>
<jsp:include page="/UnsetSessionServlet" flush="true" />
</head>
<body >
	<form method="POST" action="LoginServlet">
	<table style="text-align: right;">
		<tr><td></td></tr>
		<tr>
			<td style="height: 20px; text-align: right; ">User Name:</td>
			<td style="height: 20px; text-align: left; "><input type="text" name="username" /></td>
		</tr> 
		<tr>
			<td style="height: 20px; text-align: right; ">Password:</td>
			<td style="height: 20px; text-align: left; "><input type="password" name="password" /></td>
		</tr>
		<tr>
			<td></td>
			<td style="height: 20px; text-align: left; "><input type="submit" value="Login" /></td>
		</tr> 	
		<tr><td></td></tr>
    </table>
    </form>
</body>
</html>