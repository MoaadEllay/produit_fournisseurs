package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.AbandonedConnectionCleanupThread;

import Model.ConnectBd;
import Model.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
		    AbandonedConnectionCleanupThread.shutdown();
		} catch (InterruptedException e) {
		 
		    e.printStackTrace();
		}
			try {
				ConnectBd.init();
				String email=request.getParameter("email");
				String password=request.getParameter("password");
				PrintWriter out= response.getWriter();
				if((email!=null) && (password!=null))
				{
				User u= ConnectBd.findUser(email,password);
				
				if (u!=null)
				{
					 RequestDispatcher requestDispatcher = request.getRequestDispatcher("/addProduct.jsp") ;
					    
				     // inclusion de cette ressource
				    requestDispatcher.forward(request, response) ;
					
				}
				else
				{
					out.println("Afficher une page d'erreur");
				}
				}
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

}
