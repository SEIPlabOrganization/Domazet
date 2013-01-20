package project1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JMBAGappServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if((request.getParameter("name")!=null) && (request.getParameter("surname")!=null) && (request.getParameter("name")!="") && (request.getParameter("surname")!="")){
			try{
				PrintWriter out = response.getWriter();
				MySQLcon db = new MySQLcon("jdbc:mysql://localhost/mydb", "root", "a");
				ResultSet r=db.Quer("SELECT * FROM Users WHERE Name='"+(String) request.getParameter("name")+"' AND Surname='"+(String) request.getParameter("surname")+"';");
				out.println("<hr/>");
				if(r.first()){
					out.println("<table>");
					out.println("<tr><th>JMBAG</th><th>Name</th><th>Surname</th></tr>");
					do{
						out.println("<tr>");
						out.println("<td>"+r.getString("idUsers")+"</td>");
						out.println("<td>"+r.getString("Name")+"</td>");
						out.println("<td>"+r.getString("Surname")+"</td>");
						out.println("</tr>");
					}while(r.next());
					out.println("</table>");
				}else{
					out.println("No user containing name: <b>"+request.getParameter("name")+"</b> and surname: <b>"+request.getParameter("surname")+"</b>.");
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}
