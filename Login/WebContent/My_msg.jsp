<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
content = new Array();
subject = new Array();
temp;
tempcontent;
tempsubject;
function readcontent(i){
	temp=document.getElementById("main").innerHTML;
	tempcontent=content[i];
	tempsubject=subject[i];
	document.getElementById("main").innerHTML="<form><input type='button' value='Back' onClick='backtolist();' /> Subject: "+tempsubject+"</form><p>"+tempcontent+"</p>";
}
function backtolist(){
	document.getElementById("main").innerHTML=temp;
}
</script>

</head>
<body id='main'>
<jsp:include page="/My_msgServlet" flush="true" />
</body>
</html>