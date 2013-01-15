package project1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class MsgAppServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		PrintWriter out = response.getWriter();
		MySQLcon db = new MySQLcon("jdbc:mysql://localhost/mydb", "root", "a");
		ResultSet r1;
		ResultSet r=db.Quer("SELECT idUsers_team FROM Users_team WHERE Team_idTeam='"+(String) session.getAttribute("teamid")+"' AND Users_idUsers!='"+(String) session.getAttribute("userid")+"';");
		ArrayList<String> Wall = new ArrayList<String>();
		String Query="SELECT * FROM Messages WHERE ( "; 
		try{
			while(r.next()){
				Wall.add(r.getString("idUsers_team"));
			}
			for (int i = 0; i < Wall.size(); i++) {
				
				Query+="( Users_team_idUsers_team='"+Wall.get(i)+"' AND ";
				r1=db.Quer("SELECT Users_idUsers FROM Users_team WHERE idUsers_team='"+Wall.get(i)+"';");
				r1.first();
				Query+="Users_idUsers='"+r1.getString("Users_idUsers")+"' )";
				if(i < (Wall.size()-1))
					Query+=" OR ";
				
			}
		} catch (Exception e) {
	        e.printStackTrace();
		}
		
		Query+=") AND Messages.Read=0 ORDER BY Date ASC;";
		System.out.println(Query);
		r=db.Quer(Query);
		out.println("<table border=\"2\" cellpadding=\"0\" cellspacing=\"0\" class=\"navbar\">");
		try{
			while(r.next()){
				r1=db.Quer("SELECT Name, Surname FROM Users WHERE idUsers='"+r.getString("Users_idUsers")+"';");
				r1.first();
				out.println("<tr class=\"tablelink\">");
				out.println("<td class=\"tablelink\">");
				out.println("<a target=\"tools\" href=\"ReadApp_msg.jsp?id="+r.getString("idMessages")+"&idu="+r.getString("Users_idUsers")+"\" class=\"boxlink\">");
				out.println("From: "+r1.getString("Name")+" "+r1.getString("Surname")+"<br/>");
				out.println("<div style=\"text-align: center; padding-top: 3px; padding-bottom: 3px;\">Subject:</div>");
				out.println("<div style=\"text-align: center;\">"+r.getString("Subject")+"</div>");
				out.println("</a>");
				out.println("</td>");
				out.println("</tr>");
			}
			out.println("</table>");
		}catch(Exception e){
			e.printStackTrace();
		}
		out.println("</table>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
