<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- 	<jsp:include page="/SecTeamServlet" flush="false" />	*Mora bit u timu i logiran! -->
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add members:</title>
</head>
<body>

	<h1>Add members into your team:</h1>
		<table id="tableID" border="0" align="center">
		
		
		<form action="MoreMembersServlet" method="POST">
		
			<tr><td>Team name:</td><td><input type="text" size="67" name="TeamName"></td></tr>
			<tr><td>Member Responsibility:</td><td><jsp:include page="/ResponsibilitiesServlet" /></td></tr>
			<tr><td>Member JMBAG:</td><td><input type="text" size="67" name="JMBAGMember" /></td></tr>
		
		
		</table>
			<input type="submit" value="Create!" />		
		</form>
	


</body>
</html>