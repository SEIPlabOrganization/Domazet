package project1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReadApp_msgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		MySQLcon db = new MySQLcon("jdbc:mysql://localhost/mydb", "root", "a");
		db.Upd("UPDATE Messages SET Messages.Read=1 WHERE idMessages='"+(String) request.getParameter("id")+"';");
		ResultSet r=db.Quer("SELECT Name, Surname FROM Users WHERE idUsers='"+(String) request.getParameter("idu")+"';");
		try {
			r.first();
			out.println("From:"+r.getString("Name")+" "+r.getString("Surname"));
			out.println("<br/>");
		} catch (Exception e) {
			e.printStackTrace();
		}
		r=db.Quer("SELECT * FROM Messages WHERE idMessages='"+(String) request.getParameter("id")+"';");
		try {
			r.first();
			out.println("Subject:"+r.getString("Subject"));
			out.println("<br/><br/>");
			out.println(r.getString("Content"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);	
	}

}
