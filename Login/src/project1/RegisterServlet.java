package project1;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
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
				MySQLcon db = new MySQLcon("jdbc:mysql://localhost/test", "root", "a");
				ResultSet r = db.Quer("SELECT * FROM Users WHERE Userid='"+ session.getAttribute("userid") +"';");
				r.first();
				String pass1=r.getString("User_password");
				String pass2=r.getString("Userid");
				MessageDigest m=MessageDigest.getInstance("MD5");
				m.update(pass2.getBytes(),0,pass2.length());
				pass2 = new BigInteger(1,m.digest()).toString(16);
	
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
