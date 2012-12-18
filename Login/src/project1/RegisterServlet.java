package project1;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	   
	  
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try{
				HttpSession session = request.getSession(true);
				MySQLcon db = new MySQLcon("jdbc:mysql://localhost/mydb", "root", "a");
				ResultSet r = db.Quer("SELECT * FROM Users WHERE idUsers='"+ session.getAttribute("userid") +"';");
				r.first();
				String pass1 = r.getString("User_password");
				ProjSec sec = new ProjSec();
				String pass2 = sec.toMD5(r.getString("idUsers"));
				
				if(r.getString("User_name").equalsIgnoreCase(r.getString("Name")+"."+r.getString("Surname")) && pass2.equalsIgnoreCase(pass1)){
					session.setAttribute( "newacc", "yes"); 
					ServletContext sc = this.getServletContext();
					RequestDispatcher rd = sc.getRequestDispatcher("/Register.jsp");
					rd.forward(request, response);
				}
			}catch (Exception e){
				e.printStackTrace();
			}
		}
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
		}
}
