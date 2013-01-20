<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JMBAG App</title>
</head>
<body>
	<form action="JMBAGapp.jsp" method="post">
		Name:<input type="text" name="name"/>
		Surname:<input type="text" name="surname"/>
		<input type="submit" value="Search"/>
	</form>
<jsp:include page="/JMBAGappServlet" flush="true" />
</body>
</html>