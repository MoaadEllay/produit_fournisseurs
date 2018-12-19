package Model;

import java.awt.List;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class ConnectBd {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost:3306/produits_fournisseurs";
    static final String USER = "root";
	static final String PASS = "";
	static  Connection conn = null;
	static Statement stmt = null;

	public static void init() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{ 
	System.out.println("Connecting to database...");
	Class.forName("com.mysql.jdbc.Driver");  
	conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/produits_fournisseurs","root",""); 
	  
		
	}
	public static List findAllFournisseur() throws SQLException
	{
		
		return null;
		
	}
	public static ArrayList<Produit> findAllProduit() throws SQLException
	{
		
		  ArrayList<Produit> list_product= new ArrayList<Produit>();
	      stmt = (Statement) conn.createStatement();
	      String sql = "SELECT * FROM produit";
	      ResultSet rs = stmt.executeQuery(sql);
	      while(rs.next()){
	    	
	      list_product.add(new Produit(rs.getInt("id"),rs.getString("label"),rs.getDouble("prix"),rs.getInt("id_fournisseur")));
	    	  System.out.print("ID: " +  rs.getInt("id_fournisseur"));
	                       }
	       rs.close();
	      stmt.close();
	    //  conn.close();
	   
		return list_product;
		
	}
	
	public static User findUser(String email, String Password) throws SQLException
	{
		
		User u = null;
	      stmt = (Statement) conn.createStatement();
	      String sql = "SELECT * FROM users where email='"+email+"' and password='"+Password+"'";
	      ResultSet rs = stmt.executeQuery(sql);
	      while(rs.next()){
	    	
	    	  u= new User(rs.getInt("id_user"),rs.getString("nom"),rs.getString("prenom"),rs.getString("email"), rs.getString("password"));
	    	  
	                       }
	       rs.close();
	      stmt.close();
	    conn.close();
	   
		
		return u;
		
	}
	public static Fournisseur findFournisseurById()
	{
		return null;
		
	}
	
	public static int  AddProduct(Produit p) throws SQLException
	{
		 int result=0;
		if (conn!=null) 
		{
		 stmt = (Statement) conn.createStatement();
	     String sql = "insert into produit values("+p.getId()+",'"+p.getLabel()+"',"+p.getPrix()+","+p.getId_fournisseur()+")";
	     result=  stmt.executeUpdate(sql);
	    
		}
		else
		{
			System.out.println("Erreur connexion close");
		}
		   return result;
	}
	public static ArrayList<Produit> findProduitById() throws SQLException
	{
		
		return null;
		
	}
	
	public static ArrayList<Produit> findProduitByIdFournisseur(String idFournisseur) throws SQLException
	{
		  ArrayList<Produit> list_product= new ArrayList<Produit>();
	      stmt = (Statement) conn.createStatement();
	      String sql = "SELECT * FROM produit where id_fournisseur="+idFournisseur;
	      ResultSet rs = stmt.executeQuery(sql);
	      while(rs.next()){
	    	
	      list_product.add(new Produit(rs.getInt("id"),rs.getString("label"),rs.getDouble("prix"),rs.getInt("id_fournisseur")));
	    	 
	                       }
	       rs.close();
	      stmt.close();
	   
		return list_product;
		
	}
}
