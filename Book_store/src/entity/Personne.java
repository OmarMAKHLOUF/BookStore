package entity;

import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.ResultSet;

public class Personne {

	private int id;
	private String nom;
	private String prenom;
	private String email;
	private int tel;
	Scanner scanner = new Scanner( System.in );

	//constructeur 
	public Personne(int id, String nom, String prenom, String email, int tel) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.tel = tel;
	}
	public Personne() {
		super();
		// TODO Auto-generated constructor stub
	}
//getter & setter 	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	
	 //methods
	 
 	public static void afficheUser2() throws ClassNotFoundException, SQLException 
	{   	MyConnection c=new MyConnection();
	 
	try {
		java.sql.PreparedStatement istmt = c.c.prepareStatement("SELECT * FROM personne "); 
	ResultSet rs = (ResultSet) istmt.executeQuery();
	int i=0;
	while (rs.next()) {
	    i++;
	    System.out.println("user n° "+i);
	    System.out.println("id : " + rs.getString("id"));
	    System.out.println("nom : " + rs.getString("nom"));
	    System.out.println("prenom : " + rs.getString("prenom"));
	    System.out.println("email : " + rs.getString("email"));
	    System.out.println("tel: " + rs.getString("tel"));
 	}}
	catch(SQLException e)
	{e.printStackTrace();}



	 }
	public static void creerPersonne( ) throws ClassNotFoundException, SQLException{
		try {
			MyConnection c=new MyConnection();
			Scanner scanner = new Scanner( System.in );

		  System.out.println("saisir id");
		  int id = scanner.nextInt();
		  System.out.println("saisir nom");
		  String nom = scanner.next();
		  System.out.println("saisir prenom");
		  String prenom = scanner.next();
		  System.out.println("saisir email");
		 String email = scanner.next();
		  System.out.println("saisir tel");
		  int tel = scanner.nextInt();
		  String req="INSERT INTO personne ( id,nom,prenom,email,tel) VALUES (? , ?, ?, ?, ?)";
		   java.sql.PreparedStatement istmt = c.c.prepareStatement(req);
		   istmt.setInt(1,id);
		   istmt.setString(2, nom );
		   istmt.setString(3, prenom );
		   istmt.setString(4,email);
		   istmt.setInt(5,tel);
 		    System.out.println("Added with Success");
		    istmt.executeUpdate();
		  }catch(Exception e) {
			  System.out.println("erreur insertion");

		  }
		   
		//return new Personne(this.id,this.nom,this.prenom,this.email,this.tel);
	 
	}

 
	
}
