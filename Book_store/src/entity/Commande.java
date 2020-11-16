package entity;

import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

public class Commande {
private int id;
private String date_cmd;
private int prix_total;
private Panier panier;
private int user;
//getter setter
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
 
public int getPrix_total() {
	return prix_total;
}
public void setPrix_total(int prix_total) {
	this.prix_total = prix_total;
}
//constructeur 
public Commande() {
	super();
	// TODO Auto-generated constructor stub
}
public Commande( String date_cmd, int prix_total,Panier panier ,int user) {
	super();
	this.user=user;
	this.panier=panier;
	this.date_cmd = date_cmd;
	this.prix_total = prix_total;
}

 
/////////////////////////////////////////////////////////////////////////////
   /*  public void passerCommande() throws ClassNotFoundException, SQLException 
    { MyConnection c=new MyConnection();
    	 double pricebook = 0;
    MyConnection con;
    PreparedStatement pstmt;
    con = new MyConnection();
    
    pstmt =  (PreparedStatement) c.c.prepareStatement("INSERT INTO `commande`(id,date_cmd,prix_total,id_panier) VALUES ( ?, ?, ?, ?)");
    pstmt.setNString(1, null );
    pstmt.setString(2, date_cmd  );
     pstmt.setInt(4, prix_total );
  //  pstmt.setDouble(5,pricebook*quantite );
    System.out.println("addition with success");
    pstmt.executeUpdate();
    }
*/
//////////////////////////////////////////////////////////////////////////////

 

}
