<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<form action="New_msgServlet" method="post">
    <input type="text" maxlength="50" size="50" name="subject"/>
    <br/>
    <textarea rows="5" cols="50" name="content"></textarea>
    <br/>
    <input type="submit" value="Send"/>
</form>
<%
   	if((request.getParameter("ret"))!=null)
		out.print(request.getParameter("ret"));
%>
</body>
</html>