<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="UserPage.css" />
<script type="text/javascript">
	function Def() {
		document.getElementById("des").innerHTML="Tool Description";
	}
    function Tool1() {
    	document.getElementById("des").innerHTML="Tool1 info";
    }
    function Tool2() {
   		document.getElementById("des").innerHTML="Tool2 info";
   	}
</script>
</head>
<body onload="Def()">
	<jsp:include page="/Secservlet" flush="false" />
	<jsp:include page="/RegisterServlet" flush="false" />
	<table>
		<tr>
			<td id="tool_list">
				<table>
					<tr>
						<td>
							<a href="" target="tools" onmouseover="Tool1()" onmouseout="Def()">Tool1</a><br/><br/>
							<a href="" target="tools" onmouseover="Tool2()" onmouseout="Def()">Tool2</a><br/><br/>
							<a href="" target="tools" onmouseover="mouseOver()" onmouseout="Def()">Tool3</a><br/><br/>
							<a href="" target="tools" onmouseover="mouseOver()" onmouseout="Def()">Tool4</a>
						</td>
					</tr>
					
					<tr height="100px" >
						<td>
							<textarea rows="5" cols="22" id="des" onfocus="blur();"></textarea>
						</td>
					</tr>
				</table>
			</td>
			
			<td id="user_info">
			<jsp:include page="/UserInfoServlet" flush="true" />
			</td>
			
			<td id="msg_app">
			<iframe src="msg_app.jsp" height="100%" width="100%" frameborder="0"></iframe>
			</td>
		</tr>
	</table>
</body>
</html>