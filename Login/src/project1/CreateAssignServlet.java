package project1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CreateAssignServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public CreateAssignServlet() {
        super();
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String proposalName = request.getParameter("ImeZadatka");
		String proposerName = request.getParameter("ImeAutoraZadatka");
		String description = request.getParameter("DescriptionZadatka");
		String suggReading = request.getParameter("DescriptionZadatkaZaPripremu");
		
		
		MySQLcon db = new MySQLcon();
		
		if (db.Upd("INSERT INTO project_assignements SET name='" + proposalName + "', author='" + proposerName + "', description='" + description + "', prep_sugg_reading='" + suggReading + "';")) {
			
			RequestDispatcher rd = request.getRequestDispatcher("SuccessNewProjectAssignements.jsp");
			rd.forward(request, response);

		}
		
	}
}
