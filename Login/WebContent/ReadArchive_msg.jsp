<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="/ReadArchive_msgServlet" flush="true" />
</head>
<body>
<form action='Archive_msg.jsp' method='get'>
<input type='hidden' value='<%=(String) request.getParameter("aranger")%>' name='aranger'/>
<input type='hidden' value='<%=(String) request.getParameter("sub")%>' name='sub'/>
<input type='hidden' value='<%=(String) request.getParameter("author")%>' name='author'/>
<input type="submit" value="Back"/>
</form>
From: <%=(String) request.getParameter("from")%>
<br/>
Subject: <%=(String) request.getParameter("subject")%>
<br/><br/>
<%=(String) request.getParameter("content")%>
</body>
</html>