<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!--	<jsp:include page="/SecServlet" flush="false" />	*Samo treba bit logiran-->
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Team</title>
</head>
<body>
	
	<h1>Create new team and new project:</h1>
	<table id="tableID" border="0" align="center">
	
	<div id="idDiv">	
	<form action="CreateTeamServlet" method="POST">
	
		<tr><td>Team name:</td><td><input type="text" size="67" name="TeamName"></td></tr>
		<!-- This will be removed since we get this data from session -->
		<tr><td>Team Leader JMBAG:</td><td><input type="text" size="67" name="JMBAGTeamLeader" /></td></tr>
		
		
	</table>
		<input type="submit" value="Create!" />		
	</form>
	</div>

</body>
</html>