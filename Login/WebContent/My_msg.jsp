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
<style type="text/css">
*{ margin: 0px; padding: 0px}
table{width: 780px; text-align: center;}
a{font: bold 16px Tahoma; text-decoration: none; color: black;}
th{font: bold 16px Tahoma;}
#read{width: 60px;}
#subject{width: 480px;}
#date{width: 100px;}
#time{width: 100px;}
td{padding-top: 5px;}
#con:nth-child(4n-2) {background: #F6F6F6}
#con:nth-child(4n) {background: #D7D7D7}
#sub{padding-left: 20px; padding-right: 20px; text-align: left;}
#button{background-color: white;}
</style>
</head>
<body id='main'>
<jsp:include page="/My_msgServlet" flush="true" />
</body>
</html>