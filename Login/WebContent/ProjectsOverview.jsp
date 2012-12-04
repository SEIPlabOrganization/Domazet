<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.*" %> 
<%@ page import="java.io.*" %> 
<%@ page import="java.sql.ResultSet" %> 

<html>

<style type="text/css">
	h1 {color: white}
</style>

<head>
	<script type="text/javascript">
		function toggleMe(a)
		{
		  vrije="para"+a;
		  var e=document.getElementById(vrije);
		  vrijf="naziv"+a;
		  var temp=document.getElementById(vrijf).innerHTML;
			
		  //if(!e)return true;
		  if(e.style.display=="none")
		  {
		  temp=temp.replace("+", "-");
		  document.getElementById(vrijf).innerHTML = temp;
			//document.getElementById("btn1").value="-";
			e.style.display="block";
		  }
		  else
		  {
		  temp=temp.replace("-", "+");
		  
		  document.getElementById(vrijf).innerHTML = temp;
			//document.getElementById("btn1").value="+";
			e.style.display="none";
		  }
		  
		  return true;
		}
	</script>
</head>
<body>
	<table width="1000px">
		<tr>
			<td style="background-color:#0066FF; width:600px; height:10px">
				<h1>Projects Overview</h1>
			</td>
		</tr>
	</table>
	
	
	
	<%
	int projects_count = 0;

		Class.forName("com.mysql.jdbc.Driver").newInstance(); 
		String connectionURL = "jdbc:mysql://localhost:3307/sptool"; 
		Connection connection = DriverManager.getConnection(connectionURL, "root", "root");

		if(!connection.isClosed())
		%>
		<!-- <font size="+1" color="green"> -->
		<% 
		out.println("Successfully connected to " + "MySQL server using TCP/IP...");
		
		Statement statement = connection.createStatement();
		ResultSet res = statement.executeQuery("select * from project");
		int columns = res.getMetaData().getColumnCount();
		while(res.next())
		{
			projects_count++;
		}
		res.first();
		out.println("Tablica ima " + projects_count + " redova i " + columns + " stupaca");
		//res.close();
		//statement.close();
		//connection.close();

		%>

	
	
	
	<script type="text/javascript">
	
		broj_projekata = <%=projects_count%>;
		var vrij="";
		var naziv="";
		if(broj_projekata == 0)
		{
			document.write('<p><center><i>Project database is empty</i></center></p>');

		}
		else
		{
			for (var i= 1; i<=broj_projekata; i++)
			{
				vrij="para"+i;
				naziv="naziv"+i;
				document.write('<table border="0">');
				document.write('<tr>');
				document.write('<td onclick="return toggleMe('+i+')"> <big id="'+naziv+'"> <b>+ <%=res.getString(5)%></b> </big> </td>');
				document.write('</tr>');
				document.write('<tr>');
				document.write('<td>Project no: ' + <%=res.getString(1)%> + ' | Acad.year: 2011/12 | Team name: Tim2</td>');
				document.write('</tr>');
				document.write('<tr>');
				document.write('<td id="'+vrij+'" style="display:none">TEXT</td>');
				document.write('</tr>');
				document.write('</table>');
				<%res.next();%>
			}
		}
		
	</script>
</body>
</html>