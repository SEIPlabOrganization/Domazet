package project1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			HttpSession session = request.getSession(true);
			String userid = (String) session.getAttribute("userid");
			PrintWriter out = response.getWriter();
			MySQLcon db = new MySQLcon("jdbc:mysql://localhost/mydb", "root", "a");
			ResultSet r = db.Quer("SELECT * FROM Users WHERE idUsers='"+ userid +"';");
			r.first();
			out.print("User info <br/><br/>");
			out.print("Name: "+r.getString("Name")+"<br/><br/>");
			out.print("Surname: "+r.getString("Surname")+"<br/><br/>");
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
