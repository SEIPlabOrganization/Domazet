<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
<form action="InputUsersServlet" method="post" enctype="multipart/form-data">
    <input type="file" name="file" />
    <input type="submit" value="Submit Users"/>
</form>
<br/>
<br/>
<%
   	if((request.getParameter("ret"))!=null)
		out.print(request.getParameter("ret"));
%>
</body>
</html>