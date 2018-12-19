package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import Model.ConnectBd;
import Model.Produit;

/**
 * Servlet implementation class ServletController
 */
@WebServlet("/ServletController")
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    public static List<Produit>  processRequest(int numeroRequest, String idFournisseur) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		
		ConnectBd.init();
		switch(numeroRequest)
		{
		case 1: 
			{
				List listProducts= (List) ConnectBd.findProduitByIdFournisseur(idFournisseur);
				return listProducts;
			}
	
		case 2: 
		{
				List listProducts= (List) ConnectBd.findAllProduit();
				return listProducts;
		}
	}
		return null;


	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println(" <html lang=\"en\" >"
        		+ "<head>"
        		+ " <meta charset=\"UTF-8\">"
        		+ "  <title>Produits Fournisseur</title>"
                  
        		+ "<link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/bootswatch/3.2.0/sandstone/bootstrap.min.css'>"
                + "<link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css'>"
                + "<link rel='stylesheet prefetch' href='Form.css'>"
                +"<link rel=\"stylesheet\" href=\"css/Form.css\">"
        		+"<link rel=\"stylesheet\" href=\"css/style.css\">"
        		+"</head>"
        		+"<body>"
        		+"<div class=\"container\">"  
        		+" <form id=\"contact\" action='ServletController' method=\"post\">"
        		  +"  <h4><b>Ajouter un produit à la base de données</b></h4>"
        		    +"<fieldset>"
        		      +"<input placeholder=\"Id du produit\"  name='id_produit' type=\"text\" tabindex=\"1\" required autofocus>"
        		    		  +"</fieldset>"
        		    		  +"<fieldset>"
        		     +" <input placeholder=\"Nom du produit\" name='nom_produit'   type=\"text\" tabindex=\"2\" required>"
        		     +" </fieldset>"
        		    +"<fieldset>"
        		     +" <input placeholder=\"Prix\"  name='prix_produit' type=\"text\" tabindex=\"3\" required>"
        		     +"</fieldset>"
        		    +"<fieldset>"
        		     +" <input placeholder=\"Fournisseur\" name='id_fournisseur' type=\"text\" tabindex=\"4\" required>"
        		     +" </fieldset>"
        		   
        		    +"<fieldset>"
        		     +" <button name=\"submit\" type=\"submit\" id=\"contact-submit\" data-submit=\"...Sending\">Submit</button>"
        		     +"</fieldset>"
        		    
        		    	+"</form>"
        	+"	</div>"
        		    	+"<div align=\"center\">"
                   +"<table class=\"table table-bordered table-striped\" style=\"width:50%\">"
                    
                   +" <thead>"
                     +" <tr>"
                       +" <td>"
                         +" <a href=\"#\" ng-click=\"sortType = 'name'; sortReverse = !sortReverse\">"
                           +" Id Produit "
                           +" <span ng-show=\"sortType == 'name' && !sortReverse\" class=\"fa fa-caret-down\"></span>"
                            +"<span ng-show=\"sortType == 'name' && sortReverse\" class=\"fa fa-caret-up\"></span>"
                         +" </a>"
                        +"</td>"
                       +" <td>"
                         +" <a href=\"#\" ng-click=\"sortType = 'fish'; sortReverse = !sortReverse\">"
                          +"Label Produit "
                           +" <span ng-show=\"sortType == 'fish' && !sortReverse\" class=\"fa fa-caret-down\"></span>"
                            +"<span ng-show=\"sortType == 'fish' && sortReverse\" class=\"fa fa-caret-up\"></span>"
                          +"</a>"
                        +"</td>"
                        +"<td>"
                          +"<a href=\"#\" ng-click=\"sortType = 'tastiness'; sortReverse = !sortReverse\">"
                          +"Prix (Dh) "
                           +" <span ng-show=\"sortType == 'tastiness' && !sortReverse\" class=\"fa fa-caret-down\"></span>"
                            +"<span ng-show=\"sortType == 'tastiness' && sortReverse\" class=\"fa fa-caret-up\"></span>"
                          +"</a>"
                        +"</td>"
                        +"<td>"
                        +"<a href=\"#\" ng-click=\"sortType = 'tastiness'; sortReverse = !sortReverse\">"
                        +"Id Fournisseur "
                         +" <span ng-show=\"sortType == 'tastiness' && !sortReverse\" class=\"fa fa-caret-down\"></span>"
                          +"<span ng-show=\"sortType == 'tastiness' && sortReverse\" class=\"fa fa-caret-up\"></span>"
                        +"</a>"
                      +"</td>"
                      +"</tr>"
                    +"</thead>"
                    +"<tbody>"
                    +"<tbody>");
			      //  String id = request.getParameter( "id" ); 
					try {
						List<Produit> produits=  processRequest(1, "1");
						
						for(Produit p: produits)
						{
                   out.println("<tr ng-repeat=\"roll in sushi | orderBy:sortType:sortReverse | filter:searchFish\">");
                   out.println("<td>"+p.getId()+"</td>");
                   out.println("<td>"+p.getLabel()+"</td>");
                   out.println("<td>"+p.getPrix()+"</td>");
                   out.println("<td>"+p.getId_fournisseur()+"</td>");
                  
                   out.println("</tr>");
						}
						 out.println("</tbody>");
                
						 out.println("</table>");
       
		
       		
		} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
		   out.println("</table>");
       
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        doGet(request, response);
      String id= request.getParameter("id_produit");
     String nom=request.getParameter("nom_produit");
      String prix=request.getParameter("prix_produit");
      String id_fournisseur= request.getParameter("id_fournisseur");
      Produit p = new Produit(Integer.parseInt(id), nom , Double.parseDouble(prix), Integer.parseInt(id_fournisseur));
      
        
     
     try {
       
			int result=ConnectBd.AddProduct(p);
			
				RequestDispatcher rd =null;
				ServletContext sc = getServletContext(); 
                rd = sc.getRequestDispatcher("/addProduct.jsp");  
                request.setAttribute("commande_insert",1);
                rd.forward(request, response); 
				   
				
	     
	} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

}
