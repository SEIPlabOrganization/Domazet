<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="msg_app.css" />
<jsp:include page="/SecServlet" flush="false" />
</head>
<body>
<div style="text-align:center;">
<h2>Unread Messages</h2>
</div>
<br/>
<div id="main">
<jsp:include page="/MsgAppServlet" flush="true" />
</div>
</body>
</html>