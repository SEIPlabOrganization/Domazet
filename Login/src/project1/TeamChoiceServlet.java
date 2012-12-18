package project1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class TeamChoiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			HttpSession session = request.getSession(true);
			if(request.getParameter("teamid")!=null){
				session.setAttribute("teamid", request.getParameter("teamid"));
				ServletContext sc = this.getServletContext();
				RequestDispatcher rd = sc.getRequestDispatcher("/UserPage.jsp");
				rd.forward(request, response);
			}else{
				String userid = (String) session.getAttribute("userid");
				PrintWriter out = response.getWriter();
				MySQLcon db = new MySQLcon("jdbc:mysql://localhost/mydb", "root", "a");
				ResultSet r = db.Quer("SELECT * FROM Users_team WHERE Users_idUsers='"+ userid +"';");
				ResultSet r2;
				out.print("<table>");
				if(r.next()){
					r2 = db.Quer("SELECT * FROM Team WHERE idTeam='"+r.getString("Team_idTeam")+"';");
					if(r2.first()){
						out.print("<tr><td>Team ID:</td>");
						out.print("<td>"+r.getString("Team_idTeam")+"</td>");
						out.print("<td rowspan='2'><a href='TeamChoice.jsp?teamid="+r.getString("Team_idTeam")+"'>Chose</a></td></tr>");
						out.print("<tr><td>Team Name:</td>");	
						out.print("<td>"+r2.getString("Name")+"</td></tr>");
						out.print("<tr><td colspan='3'><hr></td></tr>");	
						out.print("<tr><td colspan='3' style='height: 20px;'></td></tr>");
					}
				}
				out.print("<tr><td colspan='2'>Create a new team</td>");
				out.print("<td><a href=''>Chose</a></td></tr>");
				out.print("</table>");
			}
		
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
