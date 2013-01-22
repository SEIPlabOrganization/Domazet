<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<!doctype html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Home Page</title>
	<script type="text/javascript">
	<!--
		if (top.location!= self.location) {
			top.location = self.location.href
		}
		if(document.URL!="http://localhost:8080/Login/Frame.jsp")
			location.href="http://localhost:8080/Login/Frame.jsp";
		
		function myPopup() {
		window.open( "JMBAGapp.jsp", "Find JMBAG", 
		"status = 1, height = 300, width = 300, resizable = 0" )
		}
	//-->
	</script>
	<link rel="stylesheet" href="Frame.css" />
	<jsp:include page="/SecServlet" flush="false" />
</head>
<body>
	<div id="main_wrapper">
		
		<header id="top_header">
		<img src="http://www.riteh.uniri.hr/images/logo1.gif" />
		<img src="http://www.riteh.uniri.hr/images/logo2.gif" />
		<h1>Prototip</h1>
		</header>
		
		<jsp:include page="/FrameServlet" flush="true" />

		<footer id="bottom_footer">
		info
		</footer>
		
	</div>
</body>
</html>
