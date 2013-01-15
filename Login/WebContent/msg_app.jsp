<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="msg_app.css" />
<jsp:include page="/Secservlet" flush="false" />
</head>
<body>
<h2>Unread messages:</h2>
<br/>
<div id="main">
<jsp:include page="/MsgAppServlet" flush="true" />

<!--  
		<table border="2" cellpadding="0" cellspacing="0" class="navbar">
			<tr class="tablelink">
				<td class="tablelink">
				<a href="" class="boxlink">
					From: Neko<br/>
					<div style="text-align: center; padding-top: 3px; padding-bottom: 3px;">Subject:</div>
					<div style="text-align: center;">neki subjekt koj sam n</div>
				</a>
				</td>
			</tr>
			<tr class="tablelink">
				<td class="tablelink">
				<a href="" class="boxlink">
					From: Neko<br/>
					<div style="text-align: center; padding-top: 3px; padding-bottom: 3px;">Subject:</div>
					<div style="text-align: center;">neki subjekt koj sam napisao da vidim k</div>
				</a>
				</td>
			</tr>
			
			  <tr class="tablelinkprof">
				<td class="tablelinkprof">
				<a href="" class="boxlinkprof">
					From: Neko<br/>
					<div style="text-align: center; padding-top: 3px; padding-bottom: 3px;">Subject:</div>
					<div style="text-align: center;">neki subjekt koj sam n</div>
				</a>
				</td>
			</tr>
			<tr class="tablelinkprof">
				<td class="tablelinkprof">
				<a href="" class="boxlinkprof">
					From: Neko<br/>
					<div style="text-align: center; padding-top: 3px; padding-bottom: 3px;">Subject:</div>
					<div style="text-align: center;">neki subjekt koj sam napisao da vidim k</div>
				</a>
				</td>
			</tr>
			
			
		</table>
		-->
</div>
</body>
</html>