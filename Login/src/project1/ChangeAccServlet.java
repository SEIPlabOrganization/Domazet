package project1;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ChangeAccServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	   
	  
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try{
				String newusername = request.getParameter("newusername");
				String oldpassword = request.getParameter("oldpassword");
				String newpassword = request.getParameter("newpassword");
				String repeatpassword = request.getParameter("repeatpassword");
				HttpSession session = request.getSession(true);

				
				
				MessageDigest m;
				if(oldpassword!=null){
					m=MessageDigest.getInstance("MD5");
					m.update(oldpassword.getBytes(),0,oldpassword.length());
					oldpassword = new BigInteger(1,m.digest()).toString(16);
					while((32-oldpassword.length())!=0){
						oldpassword="0"+oldpassword;
					}
				}
				
				if(newpassword!=null){
					m=MessageDigest.getInstance("MD5");
					m.update(newpassword.getBytes(),0,newpassword.length());
					newpassword = new BigInteger(1,m.digest()).toString(16);
					while((32-newpassword.length())!=0){
						newpassword="0"+newpassword;
					}
				}
				if(repeatpassword!=null){
					m=MessageDigest.getInstance("MD5");
					m.update(repeatpassword.getBytes(),0,repeatpassword.length());
					repeatpassword = new BigInteger(1,m.digest()).toString(16);
					while((32-repeatpassword.length())!=0){
						repeatpassword="0"+repeatpassword;
					}
				}
				
				int i=1;
				
				if(session.getAttribute("newacc")=="yes"){
					if(newusername==null)
						i=0;
				}
				MySQLcon db = new MySQLcon("jdbc:mysql://localhost/mydb", "root", "a");
				ResultSet r = db.Quer("SELECT * FROM Users WHERE idUsers='"+ session.getAttribute("userid") +"';");
				r.first();
				if(!oldpassword.equalsIgnoreCase(r.getString("User_password")))
					i=0;
				if(newpassword.equalsIgnoreCase(null))
					i=0;
				if(!newpassword.equalsIgnoreCase(repeatpassword))
					i=0;
				if(i==1){
					if(session.getAttribute("newacc")=="yes")
						db.Upd("UPDATE Users SET User_name='"+newusername+"' WHERE idUsers='"+ session.getAttribute("userid") +"' ;");
					db.Upd("UPDATE Users SET User_password='"+newpassword+"' WHERE idUsers='"+ session.getAttribute("userid") +"' ;");
					System.out.println( "UPDATE Users SET User_password='"+newpassword+"' WHERE idUsers='"+ session.getAttribute("userid") +"' ;");
					session.invalidate();
					request.getRequestDispatcher("/LogIn.jsp").forward(request, response);
				}else{
					 request.getRequestDispatcher("/Register.jsp").forward(request, response);
				}
			}catch (Exception e){
				e.printStackTrace();
			}
	}

}
