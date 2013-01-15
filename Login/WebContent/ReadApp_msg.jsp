<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<form action='UserPage.jsp' method='get'>
<input type="submit" value="Back"/>
</form>
<jsp:include page="/ReadApp_msgServlet" flush="true" />
</body>
</html>