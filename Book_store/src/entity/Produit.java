package entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

public class Produit {
private int id ;
private String designation;
private String description ;
private String date_relase ;

private int prixuni ;
private int qte_stock ;
 
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getDesignation() {
	return designation;
}
public void setDesignation(String designation) {
	this.designation = designation;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public int getPrixuni() {
	return prixuni;
}
public void setPrixuni(int prixuni) {
	this.prixuni = prixuni;
}
public int getQte_stock() {
	return qte_stock;
}
public void setQte_stock(int qte_stock) {
	this.qte_stock = qte_stock;
}


public String getDate_relase() {
	return date_relase;
}
public void setDate_relase(String date_relase) {
	this.date_relase = date_relase;
}
 
 
public Produit(int id, String designation, String description, String date_relase, int prixuni, int qte_stock ) {
	super();
	this.id = id;
	this.designation = designation;
	this.description = description;
	this.date_relase = date_relase;
	this.prixuni = prixuni;
	this.qte_stock = qte_stock;
 }
public Produit() {
	super();
 }
Scanner scanner = new Scanner( System.in );
public void creer()throws ClassNotFoundException, SQLException {
	try {
	MyConnection c=new MyConnection();
 	
	  System.out.println("saisir id");
	  this.id = scanner.nextInt();
	  System.out.println("saisir designation");
	  this.designation = scanner.next();
	  System.out.println("saisir description");
	  this.description = scanner.next();
	  System.out.println("saisir date release");
	  this.date_relase = scanner.next( );
	  System.out.println("saisir prixuni");
	  this.prixuni = scanner.nextInt();
	  System.out.println("saisir qte_stock");
	  this.qte_stock = scanner.nextInt();
	     
 	 String req="INSERT INTO book ( id,designation,description,date_relase,prixuni,qte_stock) VALUES (?,? , ?, ?, ?, ?)";
	   java.sql.PreparedStatement istmt = c.c.prepareStatement(req);
	   istmt.setInt(1,this.id);
	   istmt.setString(2, this.designation );
	   istmt.setString(3, this.description );
	   istmt.setString(4,this.date_relase);
	   istmt.setInt(5,this.prixuni);
	   istmt.setInt(6, this.qte_stock);
	    System.out.println("Added with Success");
	    istmt.executeUpdate();
	  }catch(Exception e) {
		  System.out.println("erreur insertion");

	  }
 
	  //new Produit(this.id,this.designation,this.description,this.date_relase,this.prixuni,this.qte_stock);
 
}

///////////////////////////////////////////////////////////////////
public static void afficheProduit2() throws ClassNotFoundException, SQLException 
{   	MyConnection c=new MyConnection();
 
try {
	java.sql.PreparedStatement istmt = c.c.prepareStatement("SELECT * FROM Book "); 
ResultSet rs = (ResultSet) istmt.executeQuery();
int i=0;
while (rs.next()) {
    i++;
    System.out.println("Book n° "+i);
    System.out.println("id : " + rs.getString("id"));
    System.out.println("designation : " + rs.getString("designation"));
    System.out.println("description : " + rs.getString("description"));
    System.out.println("date_relase : " + rs.getString("date_relase"));
    System.out.println("prixuni: " + rs.getString("prixuni"));
    System.out.println("qte_stock: " + rs.getString("qte_stock"));
}}
catch(SQLException e)
{e.printStackTrace();}



 }
///////////////////////////////////////////////////////////////////
 
public String afficheProduit() {
	return "Produit [id=" + id + ", designation=" + designation + ", description=" + description + ", date_relase="
			+ date_relase + ", prixuni=" + prixuni + ", qte_stock=" + qte_stock + "]";
}
 
 

}
